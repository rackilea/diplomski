String hoursrminfield; // you better declare any variable you are using

// wrap hours in a Double, then use toString() on that Double
hoursminfield = Double.valueOf(hours).toString(); 

// or else a different way to wrap in a double using the Double constructor:
(new Double(hours)).toString(); 

// or else use the very helpful valueOf() method from the class String which will 
// create a string version of any primitive type:
hoursminfield = String.valueOf(hours);