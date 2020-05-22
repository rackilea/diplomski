public class ChipView extends ImageView {
    private int[] currentLocation = new int[2];
    /*.....
      * blah,blah,blah
      * .....*/

    public void init() {
        this.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                int[] newLocation = new int[2];
                v.getLocationOnScreen(newLocation);
                Log.d("New location:", "("+newLocation[0]+","+newLocation[1]+")");
                /** Do whatever is needed with old and new locations **/
                currentLocation = newLocation;
            }
        });
    }