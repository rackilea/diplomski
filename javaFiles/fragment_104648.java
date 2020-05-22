import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.ArtifactHandler;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.building.ModelBuildingRequest;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.DefaultProjectBuildingRequest;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuilder;
import org.apache.maven.project.ProjectBuildingException;
import org.apache.maven.project.ProjectBuildingRequest;
import org.eclipse.aether.transfer.ArtifactNotFoundException;

@Mojo(name = "foo", requiresDependencyResolution = ResolutionScope.TEST)
public class MyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${session}", readonly = true, required = true)
    private MavenSession session;

    @Component
    private ArtifactHandler artifactHandler;

    @Component
    private ProjectBuilder projectBuilder;

    public void execute() throws MojoExecutionException, MojoFailureException {
        Set<Artifact> visitedArtifacts = new HashSet<Artifact>();
        for (Dependency dependency : project.getDependencyManagement().getDependencies()) {
            printDependencyTree(toArtifact(dependency), "", visitedArtifacts);
        }
    }

    private void printDependencyTree(Artifact artifact, String level, Set<Artifact> visitedArtifacts) throws MojoExecutionException {
        getLog().info(level + "+ " + artifact);
        for (Dependency transitive : getTransitiveDependencies(artifact)) {
            Artifact transitiveArtifact = toArtifact(transitive);
            if (!visitedArtifacts.contains(transitiveArtifact)) {
                visitedArtifacts.add(transitiveArtifact);
                printDependencyTree(transitiveArtifact, level + "  ", visitedArtifacts);
            }
        }
    }

    private List<Dependency> getTransitiveDependencies(Artifact artifact) throws MojoExecutionException {
        try {
            ProjectBuildingRequest buildingRequest = new DefaultProjectBuildingRequest(session.getProjectBuildingRequest());
            buildingRequest.setValidationLevel(ModelBuildingRequest.VALIDATION_LEVEL_MINIMAL);
            buildingRequest.setProject(null);
            MavenProject mavenProject = projectBuilder.build(artifact, buildingRequest).getProject();
            return mavenProject.getDependencies();
        } catch (ProjectBuildingException e) {
            if (e.getCause() != null && e.getCause().getCause() instanceof ArtifactNotFoundException) {
                //ignore
                return new ArrayList<Dependency>();
            }
            throw new MojoExecutionException("Error while building project", e);
        }
    }

    private Artifact toArtifact(Dependency dependency) {
        return new DefaultArtifact(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion(), dependency.getScope(), dependency.getType(), dependency.getClassifier(), artifactHandler);
    }

}