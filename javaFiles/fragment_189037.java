public class MyGLActivity extends Activity {
    //...    
    private GLSurfaceView glView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceView(this);
        glView.setEGLConfigChooser(8 , 8, 8, 8, 16, 0);
        glView.setRenderer(new MyGlRenderer(this));
        this.setContentView(glView);
    }
    //...
}