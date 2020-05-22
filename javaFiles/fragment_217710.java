/**
 * Goal which generates a group name.
 *
 * @goal generate
 * @phase initialize
 */
public class GroupNameGeneratorMojo extends AbstractMojo {

    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        String groupName = ... ;
        project.getProperties().setProperty("uniqueGroupName", groupName);
    }

}