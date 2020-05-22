if(jToggleButton2.isSelected()){
          new Thread(new Runnable(){

          public void run(){
                  long start = null;
                  do{
                         start = System.currentTimeMillis();
                        jButton1ActionPerformed(evt);
                   }while(jToggleButton2.isSelected() &&jSystem.currentTimeMillis()-start>3000)
          }
          }).start();

    }