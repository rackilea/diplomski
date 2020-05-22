int noofWindows = selenium.getAllWindowNames().length;
        if (noofWindows > 1){
        //selects the second window 
        selenium.selectWindow(selenium.getAllWindowIds()[2]);
        //Prints the message in the alert window
        System.out.println(selenium.getAlert());
        }