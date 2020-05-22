public class MyRenderer implements Renderer{

    private boolean startCalc = false;
    private boolean finishCalc = false;

    public void startCalc(){
        finishCalc = false;
        startCalc = true;
    }

    public boolean isFinishedCalc(){
        return finishCalc;
    }

    public void onDraw(GL10 gl){

        if(startCalc){
            // do calculation using GL handle
            // always performed in the GL thread

            finishCalc = true;
            startCalc = false;
        }

        // draw

    }



}