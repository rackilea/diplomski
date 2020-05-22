public static class LoadImageApp
    extends Component {
    private GazeListener gazeListener;
    public LoadImageApp(GazeListener aGazeListener) {
        this.gazeListener = aGazeListener;
    }
    ...
    public void paint(Graphics g) {
        ...
        // don't do the next line
        //GazeListener a = new GazeListener();
        //System.out.println(a.getX1().toString()); //--> doesn't work, return an empty array
        System.out.println(this.gazeListener.getX1().toString()); 
        ...
    }
}