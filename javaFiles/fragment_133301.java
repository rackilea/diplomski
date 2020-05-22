public void addTextBlock(double length, double width, double height) {
    shapecontrol.makeBlock(length, width, height);
        InfoShapeTextArea.clear(); // or setText("") or whatever will clear the text area
        for(int i = 0; i < shapecontrol.getShapeCollection().giveCollection().size(); i++)
        {
            InfoShapeTextArea.append(shapecontrol.getShapeCollection().giveShape(i).toString() + "\n");
        }
}