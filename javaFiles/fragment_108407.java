public class CustomEditText extends EditText {
        public CustomEditText(Context context) {
            super(context);
            init();
        }

        public CustomEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        private void init() {
            setFilters(new InputFilter[]{new EmojiIncludeFilter()});
        }

        private class EmojiIncludeFilter implements InputFilter {

            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    int type = Character.getType(source.charAt(i));
                    if (type != Character.SURROGATE && type != Character.OTHER_SYMBOL) {
                        // Other then emoji value will be blank
                        return "";
                    }
                }
                return null;
            }
        }
    }