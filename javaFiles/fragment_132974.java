public interface IVideoManager {}


public class VideoManager implements IVideoManager {


  private static class HardwareManagersHolder {

    public IVideoManager videoManager;

    public void configureManager() {
      videoManager = VideoManager.getInstance();
    }
  }

  private static class VideoManagerHolder {

    public static final VideoManager VIDEO_MANAGER_INSTANCE = new VideoManager();
  }

  public static VideoManager getInstance() {
    return VideoManagerHolder.VIDEO_MANAGER_INSTANCE;
  }

  public static void main(String[] arg) {
    System.out.println("Start test");
    HardwareManagersHolder h = new HardwareManagersHolder();
    h.configureManager();
    if (h.videoManager == null) {
      System.out.println("VideoManager is null");
    }
    System.out.println("Test finished");
  }

}