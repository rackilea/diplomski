bool xReleased = false, yReleased = false;
Component[] components = controller.getComponents();
for(Component component : components) {
    if(component.isAnalog()) { //test that controller is analog
        Identifier id = component.getIdentifier();
        float axisPosition = component.getPollData(); //range: -1 to 1
        if(id == Component.Identifier.Axis.X && axisPosition == 0)
            xReleased = true;
        if(id == Component.Identifier.Axis.Y && axisPosition == 0)
            yReleased = true;
    }
}

if(xReleased && yReleased) {
    //do something...
}