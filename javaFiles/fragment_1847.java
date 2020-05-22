public class Questions {

        private static final int QUESTIONS[] = {
                R.string.text1,
                R.string.text2
        };

        private Context context;

        public Questions(Context context) {
            this.context = context;
        }

        public String getString(int index) {
            return context.getString(QUESTIONS[index]);
        }
    }