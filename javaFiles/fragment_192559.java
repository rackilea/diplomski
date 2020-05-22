final Activity act = getActivity(); //only neccessary if you use fragments
if (act != null)
    act.runOnUiThread(new Runnable() {
        public void run() {
            yourAdapter.refreshAdapter(item);
        }
    });