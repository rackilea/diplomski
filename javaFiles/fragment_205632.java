public void write() {

    label.setText("FIRST TIME");

    new Thread(()->{ //use another thread so long process does not block gui
        for(int i=1;i<=6;i++)   {
            String text;
            if(i == 6 ){
                text = "LAST TIME";
            }else{
                 final int j = i;
                 text = "Value "+j;
            }

            //update gui using fx thread
            Platform.runLater(() -> label.setText(text));
            try {Thread.sleep(2000);} catch (InterruptedException ex) { ex.printStackTrace();}
        }

    }).start();
}