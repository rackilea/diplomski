import javafx.scene.paint.Color;
try {
    // Setup code
    Method m = Color.class.getMethod("rgb", int.class, int.class, int.class);

    // Your code
    Object[] myColorData = {127, 42, 251};
    Color myColor = (Color)m.invoke(null, myColorData);  // Invoke static method with an array of arguments

    // Confirmation
    System.out.println(myColor);

    // OMG this hurts
} catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException|NoSuchMethodException|SecurityException e) {}