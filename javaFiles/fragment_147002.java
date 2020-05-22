final Frame window = new Frame("This is the Frame's Title Bar!");
window.add(new Label("This is the Frame."));
window.setSize(300,200);
window.setVisible(true);

window.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent we){
        window.dispose();
    }
});