startCaptureButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            /*Try adding ExecutorService code here */
EspduReceiver.stopCapture = false;
            pool.execute(new Runnable(){
                public void run(){
                    /*For some reason, the call to EspduReceiver.receivePdu(); doesn't work if the capture has already been stopped once.
                     * Tried surrounding it with a try/catch block, but this didn't make a difference */
                    try{
                        EspduReceiver.receivePdu();
                    } catch(Exception e){
                        System.out.println("Cannot start capture again after stopping");
                    }
                }
            });