//other imports same as previous answer
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;
import org.apache.maven.project.ProjectBuildingException;

/**
 * Obtain the artifact defined by the groupId, artifactId, and version from the
 * remote repository.
 * 
 * @goal bootstrap
 */
public class BootstrapAppMojo extends AbstractMojo {

    /**
     * Used to resolve the maven project.
     * 
     * @parameter expression=
     *            "${component.org.apache.maven.project.MavenProjectBuilder}"
     * @required
     * @readonly
     */
    private MavenProjectBuilder mavenProjectBuilder;

    //rest of properties same as before.

    /**
     * The target pom's version
     * 
     * @parameter expression="${bootstrapVersion}"
     * @required
     */
    private String bootstrapVersion;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            Artifact pomArtifact = this.factory.createArtifact(
                bootstrapGroupId, bootstrapArtifactId, bootstrapVersion,
                "", bootstrapType);

            MavenProject project = mavenProjectBuilder.buildFromRepository(
                pomArtifact, this.remoteRepositories, this.localRepository);

            //do something with the project...
        } catch (ProjectBuildingException e) {
            getLog().error("can't build bootstrapped pom", e);
        }
    }
}