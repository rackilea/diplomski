public class MyImage {

    private ImageView mImageView;
    private Activity mActivity;
    private ViewGroup mViewGroup;

    public MyImage(Activity activity) {
       mActivity = activity;
    }

    public MyImage(ViewGroup viewGroup) {
       mViewGroup = viewGroup;
    }

    public MyImage(Activity activity,int id) {
       mActivity = activity;
       mImageView = createViewById(id);
    }

    public MyImage(ViewGroup viewGroup,int id) {
       mViewGroup = viewGroup;
       mImageView = createViewById(id);
    }

    public ImageView createViewById(int id) {
        if (mActivity != null) {
            ImageView view = mAcitivity.findViewById(id);
            if (view == null)
                throw new IllegalStateException("Can't find resource with id = " + id);
            return view;
        }
        if (mViewGroup != null) {
            ImageView view = mViewGroup.findViewById(id);
            if (view == null)
                throw new IllegalStateException("Can't find resource with id = " + id);
            return view;
        }
        throw new IllegalStateException("Can't create view. Looks like a parent null.");
    }
}