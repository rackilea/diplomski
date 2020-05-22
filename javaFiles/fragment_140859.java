@Mojo(name = "demo")
public class DemoMojo extends AbstractMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {
    getLog().info("Hello world!");
  }

}