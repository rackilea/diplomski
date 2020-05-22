private void changeColor(){
    r = builder.getSldR().getValue();
    g = builder.getSldG().getValue();
    b = builder.getSldB().getValue();
    a = builder.getSldAlpha().getValue();
    applyColor(builder.getColorShow());
    builder.repaint();
}