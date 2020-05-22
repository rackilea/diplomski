CLPlatform platform = CLPlatform.getPlatforms().get(0);
List<CLDevice> devices = platform.getDevices(CL_DEVICE_TYPE_ALL, new Filter<CLDevice>() {
    public boolean accept(CLDevice device) {
        CLDeviceCapabilities caps = CLCapabilities.getDeviceCapabilities(device);
        return caps.CL_KHR_gl_sharing;
    }
});