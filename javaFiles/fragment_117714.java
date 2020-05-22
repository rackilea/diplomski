public class View extends Object {...}
public class Label extends View {...}
public class Button extends View {...}

public View findViewById(String id) {...}

//normal assignment
View v = findViewById(viewID); 

//implicit casting to base class
Object o = findViewById(objectID); 

//compile time error because the return might not be a Button
Button b = findViewById(buttonID);

//explicit cast forces compiler to treat the return as a Button
//if the return is not a Button, then ClassCastException is trown at runtime
Button bb = (Button)findViewById(buttonID);