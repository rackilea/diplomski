public class MenuControllerListener implements ControllerListener {

private final Group buttonGroup;

private int currentButtonIndex = 0;

public MenuControllerListener(Group buttonGroup) {
    this.buttonGroup = buttonGroup;
}

@Override public void connected(Controller controller) { }
@Override public void disconnected(Controller controller) { }

@Override
public boolean buttonDown(Controller controller, int buttonCode) {
    if(buttonGroup.getChildren().size == 0) return false;
    if(controller.getName().toLowerCase().contains("xbox") &&
       controller.getName().contains("360")){
        switch(buttonCode) {
        case Xbox360Pad.BUTTON_A:
            Actor currentButton = buttonGroup.getChildren().get(currentButtonIndex);
            return clickButton(currentButton);
        }
    }
    return false;
}

@Override
public boolean buttonUp(Controller controller, int buttonCode) {
    if(buttonGroup.getChildren().size == 0) return false;
    if(controller.getName().toLowerCase().contains("xbox") &&
       controller.getName().contains("360")){
        switch(buttonCode) {
        case Xbox360Pad.BUTTON_A:
            Actor currentButton = buttonGroup.getChildren().get(currentButtonIndex);
            return releaseButton(currentButton);
        }
    }
    return false;
}

/**
 * Simulate button click down.
 * @param button
 * @return
 */
private boolean clickButton(Actor button) {
    InputEvent event = Pools.obtain(InputEvent.class);
    event.setType(Type.touchDown);
    event.setButton(Input.Buttons.LEFT);

    button.fire(event);
    boolean handled = event.isHandled();
    Pools.free(event);
    return handled;
}

/**
 * Simulate button click release.
 * @param button
 * @return
 */
private boolean releaseButton(Actor button) {
    InputEvent event = Pools.obtain(InputEvent.class);
    event.setType(Type.touchUp);
    event.setButton(Input.Buttons.LEFT);

    button.fire(event);
    boolean handled = event.isHandled();
    Pools.free(event);
    return handled;
}

@Override
public boolean axisMoved(Controller controller, int axisCode, float value) { return false; }

@Override
public boolean povMoved(Controller controller, int povCode, PovDirection value) {
    if(buttonGroup.getChildren().size == 0) return false;
    if(controller.getName().toLowerCase().contains("xbox") &&
       controller.getName().contains("360")){

        unselectButton(buttonGroup.getChildren().get(currentButtonIndex));

        switch(value) {
        case north:
        case west:
            currentButtonIndex--;
            break;
        case south:
        case east:
            currentButtonIndex++;
            break;
        default:
            break;
        }

        currentButtonIndex = currentButtonIndex % buttonGroup.getChildren().size;
        if(currentButtonIndex < 0) currentButtonIndex = buttonGroup.getChildren().size - 1;

        return selectButton(buttonGroup.getChildren().get(currentButtonIndex));
    }

    return false;
}

/**
 * Simulate mousing over a button.
 * @param button
 * @return
 */
private boolean selectButton(Actor button) {
    InputEvent event = Pools.obtain(InputEvent.class);
    event.setType(Type.enter);

    button.fire(event);
    boolean handled = event.isHandled();
    Pools.free(event);
    return handled;
}

/**
 * Simulate mousing off of a button.
 * @param button
 * @return
 */
private boolean unselectButton(Actor button) {
    InputEvent event = Pools.obtain(InputEvent.class);
    event.setType(Type.exit);

    button.fire(event);
    boolean handled = event.isHandled();
    Pools.free(event);
    return handled;
}

@Override public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) { return false; }
@Override public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) { return false; }
@Override public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) { return false; }
}