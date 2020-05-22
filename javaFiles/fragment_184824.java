public class someFragmentClass extends Fragment {

    Timer mTimer;
    View mView;

    TimerTask timerTask = new TimerTask(){
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                       randomMovement(img);
                    }
                }
            });
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
       Bundle savedInstanceState) {

       mView = inflater.inflate(R.layout.someFragment, container, false);

       mTimer = new Timer();
       mTimer.scheduleAtFixedRate(timerTask, 0 , 5000);

       return mView;
    }

}