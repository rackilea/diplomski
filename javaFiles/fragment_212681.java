boolean upPressed = false;
boolean downPressed = false;
...
@Override
public void keyPressed(KeyEvent e) {
    if(e.keyCode == SWT.ARROW_DOWN){
        downPressed = true;
        if (upPressed){
            // both are pressed here
        } 
    }
    else if(e.keyCode == SWT.ARROW_UP){
        upPressed = true;
        if (downPressed){
            // both are pressed here
        }
    }
}

@Override
public void keyReleased(KeyEvent e) {
    if(e.keyCode == SWT.ARROW_DOWN)
        downPressed = false;
    else if(e.keyCode == SWT.ARROW_UP)
        upPressed = false;
}