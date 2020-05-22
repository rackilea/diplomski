private boolean flag = false;

@Override
public boolean touchDown(InputEvent event, float x, float y,
        int pointer, int button) {
    if (button == Buttons.LEFT) {
        flag = true;    
    }
    //other stuff
    return true; //or whatever you want
}

@Override
public boolean touchUp(InputEvent event, float x, float y,
        int pointer, int button) {
    if (button == Buttons.LEFT) {
        flag = false;    
    }
    //other stuff
    return false; //or whatever you want
}

@Override
public void act(float delta) {
    if (flag) {
        double currentValue = Double.parseDouble(Button.getText()
                    .toString());
            if ((int) currentValue != 0)
                currentValue--;
            Button.updateText(Double.toString(currentValue));
    }
    //other stuff
}