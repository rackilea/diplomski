btnClick.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
          if(mIsFirstTime){

                image.setImageDrawable(getDrawable(R.drawable.an));
                mIsFirstTime=false;
            }else{

                image.setImageDrawable(getDrawable(R.drawable.did));
                mIsFirsTime=true;
            }
    }
  }