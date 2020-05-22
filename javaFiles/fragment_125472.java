public interface JsonObjectListener {

        public void onDone(int lastNumber);

        public void onError(String error);
    }