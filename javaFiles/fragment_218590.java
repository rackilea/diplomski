for(final ImageView light: lights) {

    h.postDelayed(new Runnable() {
        @Override
        public void run() {
            light.setBackgroundResource(R.drawable.light_white);
        }

    }, 1000);
}