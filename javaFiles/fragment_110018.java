class MyBox2dRenderer extends Box2DDebugRenderer {

    private ArrayList<Body> notRenderingBodies; // array of vodies that you dont want to render


    public MyBox2dRenderer(ArrayList<Body> notRenderingBodies) { 
        super();

        this.notRenderingBodies = notRenderingBodies; 
    }

    @Override
    protected void renderBody(Body body) {
        for (Body b : notRenderingBodies) { // loop through all bodies in array
            if (b == body){ // if given body equals by reference to one from list than return 
                return;
            }
        }
        super.renderBody(body);
    }

    public ArrayList<Body> getNotDenderingBodies() {
        return notRenderingBodies;   
    }

    public void setNotDenderingBodies(ArrayList<Body> notDenderingBodies) {
        this.notRenderingBodies = notDenderingBodies;
    }
}