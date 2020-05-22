public class FaceView extends View {

    private FaceListener mFaceListener;

    interface FaceListener {
        public void handleData(Integer[] cxArr, Integer[] cyArr);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.mFaceListener = faceListener;
    }


    private void drawFaceAnnotations(Canvas canvas, double scale) {
        // your code here
        // notify listener

       List<Integer> cxList = new ArrayList<Integer>();
       List<Integer> cyList = new ArrayList<Integer>(); 

       for (int i = 0; i < mFaces.size(); ++i) {
           Face face = mFaces.valueAt(i);

           for (Landmark landmark : face.getLandmarks()) {
                cx = (int) (landmark.getPosition().x * scale);
                cy = (int) (landmark.getPosition().y * scale);
                canvas.drawCircle(cx, cy, 5, paint);

                cxList.add(cx);
                cyList.add(cy);

            }
        }

        Integer[] cxArr = cxList.toArray(new Integer[cxList.size()]);
        Integer[] cyArr = cyList.toArray(new Integer[cyList.size()]);

        mFaceListener.handleData(cxArr,cyArr);
    }
}