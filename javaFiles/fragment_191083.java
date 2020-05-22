public class DeviceInfoProvider {
    private final DisplayProvider display;
    private final BuildProvider build;

    public DeviceInfoProvider(DisplayProvider display, BuildProvider build) {
        this.display = display;
        this.build = build;
    }

    public DeviceInfo getScreenParams() {
        int screenWidth = display.widthPixels;
        int screenHeight = display.heightPixels;
        String model = build.Model;
        DeviceInfo params = new DeviceInfo(screenWidth, screenHeight, model);
        return params;
    }
}