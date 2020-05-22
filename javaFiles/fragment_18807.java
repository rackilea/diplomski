Bar myBar = new Bar();
    void changeIt(Bar aBar){ 
        aBar.barNum = 99; //Here aBar is a pointer to the myBar above and changes it
        aBar = new Bar();  //Here aBar points to a new myBar instance
        a.barNum = 420; //This will be lost when you leave the method with the new instance created
    }