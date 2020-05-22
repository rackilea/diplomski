new Thread(new Runnable() {         
        @Override
        public void run() {
            try {
            Instrumentation inst = new Instrumentation();
            for ( int i = 0; i < 10; ++i ) {
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
                Thread.sleep(2000);
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                Thread.sleep(2000);
            }
            }
            catch(InterruptedException e){
            }
        }   
    }).start();