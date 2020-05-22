final ImageView image1 =  (ImageView) v.findViewById(R.id.coin1);
image1.post(new Runnable() {

        @Override
        public void run() {
            AnimationDrawable ani = (AnimationDrawable) image1.getBackground();
            ani.start();
        }
    });