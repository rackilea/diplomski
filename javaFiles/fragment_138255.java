public class HelloJME_3 extends SimpleApplication {


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

        inputManager.addMapping("RotateX", 
                new MouseAxisTrigger(MouseInput.AXIS_X, true)
        );

        inputManager.addMapping("RotateX_negative", 
                new MouseAxisTrigger(MouseInput.AXIS_X, false)
        );


        inputManager.addListener(new AnalogListener() {

            @Override
            public void onAnalog(String name, float value, float tpf) {

                if( "RotateX".equals(name) ) {
                    geom.rotate(0, (float) (value*speed), 0);

                }else if("RotateX_negative".equals(name)){
                    geom.rotate(0, (float) (-value*speed), 0);
                }
            }
        }, "RotateX", "RotateX_negative");


    }
}