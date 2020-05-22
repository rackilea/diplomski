public void changeColor() {

    if (comp.getColor() == Color.RED) {
        comp.setColor(Color.GREEN);
    } else {
        comp.setColor(Color.RED);
    }

    comp.repaint();
}