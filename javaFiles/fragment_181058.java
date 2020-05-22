lvfonts.postDelayed(new Runnable() {
            @Override
            public void run() {
                applyCustomFont((ViewGroup)rootView);
                 // or call you function to change the Typeface from here 
            }
            }, 10);