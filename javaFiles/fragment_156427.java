public class MainActivity extends Activity implements CvCameraViewListener2,OnTouchListener 
{

Bitmap sourceBitmap,descBitmap,sourceBitmap1;
ImageView view,view2;
SurfaceView amSurfaceView ;
Mat mRgba;
  private CameraBridgeViewBase mOpenCvCameraView;     
private BaseLoaderCallback  mLoaderCallback = new BaseLoaderCallback(this) {
    @Override
    public void onManagerConnected(int status) {
        switch (status) {
            case LoaderCallbackInterface.SUCCESS:
            {
                Log.i("Yesssssssss", "OpenCV loaded successfully");
                mOpenCvCameraView.enableView();
            } break;
            default:
            {
                super.onManagerConnected(status);
            } break;
        }
    }

};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    // initialise bitmap for crop is here
    Bitmap bitmap_source=BitmapFactory.decodeResource(getResources(), R.drawable.quadone);
    if(bitmap_source==null)
        Log.e("bitmap Null","nulllllll");

    // these values should not exceed the limits of bitmap..



    Log.e("Bitmap"," "+bitmap_source.getWidth()+" "+bitmap_source.getHeight());


    sourceBitmap =BitmapFactory.decodeResource(getResources(), R.drawable.quadone);
    sourceBitmap1 =BitmapFactory.decodeResource(getResources(), R.drawable.quadone);
    descBitmap =BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    view = (ImageView) findViewById(R.id.imageView1);
    view2=(ImageView) findViewById(R.id.imageView2);

    view.setImageBitmap(sourceBitmap1);
    view.setOnTouchListener(this);
      mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.color_blob_detection_activity_surface_view);
        mOpenCvCameraView.setCvCameraViewListener(this);
    Log.e("MAtt","Startttttttttmmmmmmmmmtttttttt");
    sourceBitmap =bitmap_source;
             if (!OpenCVLoader.initDebug()) {
                    // Handle initialization error
                }
             Mat inputMat = new Mat();
             Mat outputMat = new Mat();
             descBitmap=sourceBitmap;
             Utils.bitmapToMat(sourceBitmap, inputMat);
                List<Point> src_pnt = new ArrayList<Point>();
                Point p0 = new Point(0, 0);
                src_pnt.add(p0);
                Point p1 = new Point(10, 100);
                src_pnt.add(p1);
                Point p2 = new Point(100, 125);
                src_pnt.add(p2);
                Point p3 = new Point(90, 20);                   
                src_pnt.add(p3);
                Mat startM = Converters.vector_Point2f_to_Mat(src_pnt);

                List<Point> dst_pnt = new ArrayList<Point>();
                Point p4 = new Point(0.0, 0.0);
                dst_pnt.add(p4);
                Point p5 = new Point(0.0, sourceBitmap.getHeight());
                dst_pnt.add(p5);
                Point p6 = new Point(sourceBitmap.getWidth(), sourceBitmap.getHeight());
                dst_pnt.add(p6);
                Point p7 = new Point(sourceBitmap.getWidth(), 0);
                dst_pnt.add(p7);
                Mat endM = Converters.vector_Point2f_to_Mat(dst_pnt);
                Mat perspectiveTransform = Imgproc.getPerspectiveTransform(startM, endM);
                Size size = new Size(sourceBitmap.getWidth(), sourceBitmap.getHeight());
                Scalar scalar = new Scalar(50.0);
                Imgproc.warpPerspective(inputMat, outputMat, perspectiveTransform, size, Imgproc.INTER_LINEAR + Imgproc.CV_WARP_FILL_OUTLIERS, Imgproc.BORDER_DEFAULT, scalar);

                Log.e("1=",""+inputMat.cols()+" "+inputMat.rows());
                Log.e("outmat.."," "+outputMat.cols()+" "+outputMat.rows());
                Utils.matToBitmap(outputMat, descBitmap);
                view2.setImageBitmap(descBitmap);

             // ram@san 


}

@Override
public void onCameraViewStarted(int width, int height) {
    // TODO Auto-generated method stub
    Log.e("onCameraViewStarted","onCameraViewStarted");
}

@Override
public void onCameraViewStopped() {
    // TODO Auto-generated method stub
    Log.e("onCameraViewStopped","onCameraViewStopped");
}

@Override
public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
        // TODO Auto-generated method stub
mRgba= new Mat();
Utils.bitmapToMat(sourceBitmap, mRgba);
Utils.matToBitmap(mRgba, descBitmap);
view2.setImageBitmap(sourceBitmap);
        return mRgba;
}

@Override
public boolean onTouch(View v, MotionEvent event) {
    // TODO Auto-generated method stub
    return false;
}


}