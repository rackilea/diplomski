// (Calendar) Date function - Displays dateview on Card
final boolean keepRunning1 = true;
Thread thread_two = new Thread(){

@Override
public void run(){

    while(keepRunning1){

        // Make the thread wait half a second. If you want...
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Toast.makeText(getActivity().getApplicationContext(), "Default Signature                         Fail", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        // here you check the value of getActivity() and break up if needed
        if(getActivity() == null)
            return;

        getActivity().runOnUiThread(new Runnable(){
        @Override
        public void run(){
           TextView date = (TextView) getView().findViewById(R.id.date);
           date.setText(DateUtils.formatDateTime(getActivity().getBaseContext(), System.currentTimeMillis(),DateUtils.FORMAT_SHOW_WEEKDAY | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
           }
         });
    }
}
};thread_two.start();