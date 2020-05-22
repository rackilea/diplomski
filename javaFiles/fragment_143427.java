public void test() throws InterruptedException {
    getActivity().runOnUiThread(new Runnable() {

        @Override
        public void run() {
            getActivity().setContentView(R.layout.clock_layout);
        }
    });
    Thread.sleep(3000);
}