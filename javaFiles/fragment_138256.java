public class HelloJME_3 extends SimpleApplication {

    public static float PIXELSMOVED_TO_RADIANSROTATED=0.01f;


    public static void main(String[] args){
        HelloJME_3 app = new HelloJME_3();
        app.start(); // start the game
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1); // create cube shape
        final Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Blue);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        rootNode.attachChild(geom);              // make the cube appear in the scene


        flyCam.setEnabled(false); 

        inputManager.addMapping("MouseMoved", 
                new MouseAxisTrigger(MouseInput.AXIS_X, false),
                new MouseAxisTrigger(MouseInput.AXIS_X, true)
        );

        inputManager.addListener(new AnalogListener() {

            @Override
            public void onAnalog(String name, float value, float tpf) {
                inputManager.getCursorPosition();

                    float centredX=inputManager.getCursorPosition().x-0.5f*settings.getWidth();

                    Quaternion quat=new Quaternion();
                    quat.fromAngles(0, PIXELSMOVED_TO_RADIANSROTATED*centredX, 0);

                    geom.setLocalRotation(quat);

            }
        }, "MouseMoved");
    }
}