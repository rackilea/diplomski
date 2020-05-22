new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                     ImageView1.startAnimation(setA);

                }
            }, 2000);
          new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                     ImageView2.startAnimation(setA);

                }
            }, 4000);