final Handler handler = new Handler();
    Runnable runable = new Runnable() {

        @Override
        public void run() {
            try{
                //do your code here
                //also call the same runnable

                if (btf){
                   b6.setBackgroundColor(c);
                    btf=false;
                }else {
                   b6.setBackgroundColor(c2);
                    btf=true;
                }
            }
            catch (Exception e) {
                // TODO: handle exception
            }

    };