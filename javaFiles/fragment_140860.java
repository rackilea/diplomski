import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.sonatype.aether.RepositorySystem;
import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.collection.CollectRequest;
import org.sonatype.aether.graph.Dependency;
import org.sonatype.aether.graph.DependencyNode;
import org.sonatype.aether.repository.RemoteRepository;
import org.sonatype.aether.resolution.DependencyRequest;
import org.sonatype.aether.util.artifact.DefaultArtifact;
import org.sonatype.aether.util.graph.PreorderNodeListGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @goal findShareables
 * @phase process-resources
 */
@SuppressWarnings("unchecked")
public class ShareableJarsInWarsExtractor extends AbstractMojo
{
    // ...

    /**
     * The MavenProject object.
     *
     * @parameter expression="${project}"
     * @readonly
     */
    private MavenProject project;

    /**
     * The entry point to Aether, i.e. the component doing all the work.
     *
     * @component
     */
    private RepositorySystem repoSystem;

    /**
     * The current repository/network configuration of Maven.
     *
     * @parameter default-value="${repositorySystemSession}"
     * @readonly
     */
    private RepositorySystemSession repoSession;

    /**
     * The project's remote repositories to use for the resolution of plugins and their dependencies.
     *
     * @parameter default-value="${project.remotePluginRepositories}"
     * @readonly
     */
    private List<RemoteRepository> remoteRepos;


    public void execute() throws MojoExecutionException
    {
        Artifact projectArtifact = getProjectArtifact();
        List<Dependency> projectDependencies = getArtifactsDependencies(projectArtifact);

        for (Dependency d : projectDependencies)
        {
            if (d.getArtifact() != null && "war".equals(d.getArtifact().getExtension()))
            {
                List<Dependency> warDependencies = getArtifactsDependencies(d.getArtifact());
                // I now have all of the WAR's dependencies!! Hooray!

                // ...
            }
        }

        // ...
    }


    private List<Dependency> getArtifactsDependencies(Artifact a)
    {
        List<Dependency> ret = new ArrayList<Dependency>();

        // Note: I get the POM artifact, not the WAR or whatever.
        DefaultArtifact pomArtifact = new DefaultArtifact(a.getGroupId(), a.getArtifactId(), "pom", a.getVersion());
        CollectRequest collectRequest = new CollectRequest();
        collectRequest.setRoot(new Dependency(pomArtifact, "compile"));
        collectRequest.setRepositories(remoteRepos);

        try
        {
            DependencyNode node = repoSystem.collectDependencies(repoSession, collectRequest).getRoot();
            DependencyRequest projectDependencyRequest = new DependencyRequest(node, null);

            repoSystem.resolveDependencies(repoSession, projectDependencyRequest);

            PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
            node.accept(nlg);

            ret.addAll(nlg.getDependencies(true));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return ret;
    }


    private Artifact getProjectArtifact()
    {
        // Todo: There must be a better way!
        return new DefaultArtifact(project.getArtifact().toString());
    }


    // ...
}