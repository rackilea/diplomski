public class SocketClass {
    private OnSockectListener mListener;
    public void setListener(OnSockectListener listener) {
        mListener = listener;
    }

   private void someEvent() {
       if (mListener != nul) {
           mListener.onSomeEvent(Data data);
       }
   }
}