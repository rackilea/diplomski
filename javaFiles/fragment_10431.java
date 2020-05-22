Intent intent = getIntent();
        int frag = intent.getIntExtra("frag",0);
 if (frag == 1){
            muscle = intent.getStringExtra("muscle");
            exercise = intent.getStringExtra("exercise");
            //exercises is menu item 1 (mainActivity is 0)
            mViewPager.setCurrentItem(frag);
        }
//Another section of code
 public String getMuscle(){
        return muscle;
    }

    public String getExercise(){
        return exercise;
    }