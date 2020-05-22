class ToolbarFrame extends JFrame implements ActionListener {

    private FaceFrame faceFrame;
    ...

    public ToolbarFrame() {
        super();
        this.faceFrame = new FaceFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ...
        Face face = faceFrame.getFace();
        if (face.getSelected() == face.getFace()){
            System.out.println("Face is selected");
        }
    }
}