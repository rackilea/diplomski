repeat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(x != null ){
                if ( x.isLooping()) {
                    //player is in repeat mode , so turn it off and change repeat buttun background to normal
                    repeat.setBackgroundResource(R.drawable.repeat_off);
                    x.setLooping(false);
                }else {
                    //player isn't in repeat mode , so turn it on and change repeat buttun background to repeating image
                    repeat.setBackgroundResource(R.drawable.repeat_on);
                    x.setLooping(true);
                }
            }else {
                //player is null
            }
        }
    });