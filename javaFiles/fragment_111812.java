@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mFile = new File(getActivity().getExternalFilesDir(null), "pic.jpg");
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        public void run() {
            Log.d("HandlerThread","This is from the HandlerThread");
        takePicture();
        }
    }, 60000);
}