public class Test3D extends Activity{

private MyRenderer renderer; // keep hold of the renderer as a variable in activity
private MyAsyncTask gameLoop;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);

    myRenderer = new MyRenderer(); // create the renderer object

    GLSurfaceView mGLView = (GLSurfaceView)findViewById(R.id.glsurfaceview1);
    mGLView.setEGLConfigChooser(true);
    mGLView.setRenderer(myRenderer); // set the surfaceView to use the renderer

    gameLoop = new MyAsyncTask(); 
    gameLoop.execute(); // start a new, non-UI, thread to do something

}

/// non-UI thread (inner class of my Test3D activity)
class MyAsyncTask extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(Void... arg0) {

            myRenderer.startCalc(); // tell renderer to start calculation

            while(!myRenderer.isFinishedCalc()){

                // waiting for calc to finish, but not blocking UI thread

                try {
                    long x = 1000;
                    Thread.sleep(x);
                    // sleep the thread for x amount of time to save cpu cycles
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            publishProgress(null); 
            // when calculation has finished, we will drop out of the loop
            // and update the UI



   }

    protected void onProgressUpdate(Void... progress) {         
        // update UI
    }


}


}