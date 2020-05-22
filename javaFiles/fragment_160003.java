public class MyApplication extends Application {

    @Override
    public void init() {
        Window mainWindow = new Window("Your Application");

        // Create a color picker
        ColorPicker cp = new ColorPicker("ColorPicker", Color.RED);

        // Add a color change listener to the color picker
        cp.addListener(new ColorPicker.ColorChangeListener() {
            @Override
            public void colorChanged(ColorChangeEvent event) {
                MyApplication.this.getMainWindow()
                .showNotification("Color changed!");
            }
        });

        mainWindow.addComponent(cp);
        setMainWindow(mainWindow);
    }
}