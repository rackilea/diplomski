for(int i = 0; shouldContinue && i < in.size(); i++){
    ...
    CountDownLatch latch = new CountDownLatch(1);
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
                sb.setSpan(fcs, 0, l, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                tv.setText(sb);
                latch.countDown();
        }
    });

    latch.await();
    for(int j = 0; shouldContinue && j < in.get(i).length(); j++){
        //some code
    }
}