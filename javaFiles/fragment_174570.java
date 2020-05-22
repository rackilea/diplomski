public class CustomView extends ConstraintLayout {
        public CustomView(Context context) {
            super(context);
            init();
        }

        public CustomView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        void init() {
            inflate(getContext(), R.layout. service_selection_checkbox_layout, this);
        }
    }