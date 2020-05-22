public class ScrollViewWithMaxHeight extends ScrollView {

            public static int WITHOUT_MAX_HEIGHT_VALUE = -1;

            private int maxHeight = WITHOUT_MAX_HEIGHT_VALUE;

            public ScrollViewWithMaxHeight(Context context) {
                super(context);

 init(context, null, 0, 0);
            }

            public ScrollViewWithMaxHeight(Context context, AttributeSet attrs) {
                super(context, attrs);
 init(context, attrs, 0, 0);
            }

            public ScrollViewWithMaxHeight(Context context, AttributeSet attrs, int defStyle) {
                super(context, attrs, defStyle);
 init(context, attrs, defStyle, 0);
            }
           private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
    TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs, R.styleable.custom_ScrollViewWithMaxHeight,  defStyleAttr, defStyleRes);
     maxHeight = 
     a.getDimensionPixelSize(R.styleable.max_height,maxHeight);
        }

            @Override
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                try {
                    int heightSize = MeasureSpec.getSize(heightMeasureSpec);
                    if (maxHeight != WITHOUT_MAX_HEIGHT_VALUE
                            && heightSize > maxHeight) {
                        heightSize = maxHeight;
                    }
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.AT_MOST);
                    getLayoutParams().height = heightSize;
                } catch (Exception e) {
                    LogManager.error(this, "onMesure", "Error forcing height", e);
                } finally {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            }

            public void setMaxHeight(int maxHeight) {
                this.maxHeight = maxHeight;
            }
        }