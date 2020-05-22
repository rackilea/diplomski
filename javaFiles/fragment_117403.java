/**
 * Adapted from the
 * <a href="https://github.com/imagej/imagej-tutorials">ImageJ Tutorials</a>
 * {@code LoadAndDisplayDataset} tutorial.
 */
@Plugin(type = Command.class, menuPath = "Plugins>My Useful Command")
public class UsefulCommand implements Command {

  @Parameter
  private DatasetIOService datasetIOService;

  @Parameter
  private LogService log;

  @Parameter
  private File destination;

  @Parameter
  private Dataset image;

  @Override
  public void run() {
    try {
      image = datasetIOService.save(image, destination.getAbsolutePath());
    }
    catch (final IOException exc) {
      log.error(exc);
    }
  }

}