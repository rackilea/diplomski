public class DisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // your code here
        FaceView overlay = (FaceView) findViewById(R.id.faceView);
        overlay.setFaceListener(new FaceView.FaceListener(){
             public void handleData(int[] cxArr, int[] cyArr) {
                 // TODO: handle faces array here
             } 
        });
    }
}