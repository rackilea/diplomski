private class BoardAction extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent me) {
        //determines which panel was clicked
        Board panel = (Board) me.getSource();
        panel.setStatus("X");
        panel.repaint();//calls paint method
    }
}