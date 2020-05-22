Timer timer = new Timer();

        timer.schedule( new TimerTask(){

        public void run() { 
               //delay = 20000;

               // if the timer has not been stopped, proceed with timer
               if(!SpectroClick.stop_timer){
                   //System.out.println("20 seconds later");

                    //scanQRPanel.getCameraView().getWebcamPanel().pause();
                    stopScanning();

                    // Create the message to display
                    String text = "No QR code has been found. We suggest that you use a Manual Override." + "<br><br>" + "Press 'OK to confirm, or 'Cancel' to continue scanning for another QR code.</br>";
                    String message = "<html><div style=\"text-align: center;\">" + text + "</html>";

                    // Show the confirmation dialog screen, and wait for user input
                    int i = JOptionPane.showConfirmDialog((Component) null, message,
                            "Confirm", JOptionPane.OK_CANCEL_OPTION);

                    // User selected 'OK'
                    if (i == JOptionPane.OK_OPTION) {
                        for (SpectroClickEventListener listener : listeners) {
                            listener.userSelectedOverride();
                        }
                    }                       

                    // User did not select ok, go to new test
                    else{                           
                        startScanning();
                    }
               } else{
                  timer.cancel();
                  timer.purge();
               }
            }
         }, delay);