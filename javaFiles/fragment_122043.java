public class SmoothLayoutManager extends LinearLayoutManager
{
public static final int X_25 = 25;
public static final int X_200 = 200;
public static final float DEFAULT = X_25;

/**
 * !! IMPORTANT !!
 * If you need to add new value, don't forget add it here also
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({X_25, X_200})
private @interface Speed
{

}

private static float MILLISECONDS_PER_INCH = DEFAULT;

public SmoothLayoutManager(Context context)
{
    super(context);
}

public SmoothLayoutManager(Context context, int orientation, boolean reverseLayout)
{
    super(context, orientation, reverseLayout);
}

public SmoothLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
{
    super(context, attrs, defStyleAttr, defStyleRes);
}

public SmoothLayoutManager setSpeedOfSmooth(@Speed int iSpeed)
{
    MILLISECONDS_PER_INCH = iSpeed;

    return this;
}

@Override
public void scrollToPositionWithOffset(final int position, final int offset)
{
    super.scrollToPositionWithOffset(position, offset);
}

@Override
public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position)
{
    RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(recyclerView.getContext())
    {
        @Override
        public PointF computeScrollVectorForPosition(int targetPosition)
        {
            return SmoothLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override
        protected int getVerticalSnapPreference()
        {
            return LinearSmoothScroller.SNAP_TO_ANY;
        }

        @Override
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics)
        {
            return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
        }

        @Override
        public int calculateDtToFit(final int viewStart, final int viewEnd, final int boxStart, final int boxEnd, final int snapPreference)
        {
            return (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2);
        }
    };

    smoothScroller.setTargetPosition(position);
    startSmoothScroll(smoothScroller);
}
}