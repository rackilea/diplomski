mouseClicked( MouseEvent e ){

    // Do some stuff here

    // assume we kept a reference to the passid-in mouseListener from 3rd Party class
    // in a class variable called "passedInMouseListenerInstance"
    passedInMouseListenerInstance.mouseClicked(e);
}