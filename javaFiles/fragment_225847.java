int inew = 0; //Or any default value
    while(true){
      try{

        int iold=inew;

        inew=input.read();

        if (inew!=-1 && iold!=-1)
        {
          text=tf.getText();
          tf.setText(text+(char)inew);
        }
        if (inew!=-1 && iold=-1)
        {
          text=tf.getText();
          tf.setText(""+(char)inew);
        }

        Thread.sleep(100);
      }
      catch(Exception x){
          x.printStackTrace();
      }

      repaint();    
    }