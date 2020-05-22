//define in your class:
    Vector keysPressed = new Vector(); // to keep track of keys pressed

    //overrides the function keyPressed from "lcdui.Canvas"
    protected void keyPressed(int keyCode){
        keysPressed.addElement(new Integer(keyCode));
    }