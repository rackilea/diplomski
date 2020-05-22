BB(){
    super(); //calls AA()
    s = "hello2"; // by default `s` holds `null` value 
                  // all initialization is moved to constructors 
                  // after superconstructor call
}