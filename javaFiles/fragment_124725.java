@Override
public void onDestroy() {
    try {

         getActivity().getApplicationContext().
             unregisterReceiver(mHandleMessageReceiver);

    } catch (Exception e) {
        Log.e("UnRegister Error", "> " + e.getMessage());
    }
    super.onDestroy();
}