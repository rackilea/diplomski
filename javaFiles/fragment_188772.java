if(comando2.length < 1) {
    // the user typed only spaces
} else {
    String first = comando2[0];
    if(first.equalsIgnoreCase("exit")) { // or comando.equalsIgnoreCase("exit"), depending on whether the user is allowed to type things after "exit"
        // something here

    } else if(first.equalsIgnoreCase("enter")) {
        if(comando2.length < 2) {
            // they typed "enter" by itself; what do you want to do?
            // (probably print an error message)
        } else {
            String second = comando2[1];
            // do something here
        }
    }
}