Random rand = new Random();
Handler handler = new Handler()

Runnable r=new Runnable() {
        public void run() { 
            int value = rand.nextInt(10);
            handler.postDelayed(this, 500);     
        }
    };

handler.postDelayed(r, 500);