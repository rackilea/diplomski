public class SocketClass {
        private OnSockectListener mListener;
        private static SockectClass mInstance;

        private SocketClass() {
        }

        public SockectClass getInstance() {
            if (mInstance == null) {
                mInstance = new SockectClass();
            }
            return mInstance;
        }

        public void setListener(OnSockectListener listener) {
            mListener = listener;
        }

       private void someEvent() {
           if (mListener != nul) {
               mListener.onSomeEvent(Data data);
           }
       }
    }