class FaceFrame extends JFrame {
    private Face face;

    public FaceFrame() {
        super();
        this.face = new Face();
    }

    public Face getFace() {
        return face;
    }
}