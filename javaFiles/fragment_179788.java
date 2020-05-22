Handler h;

    onCreate(......) {

    h = new Handler();

    ....
    ....

    }


        if(editText.getText().length()==0) {  
           editText.setError("please input text"); 
           new Thread (new Runnable() {
              public void run(){
                 try{
                    Thread.sleep(1000);

                    h.post(new Runnable() {

                      editText.setText("");    // this will put the non-ui work on the ui thread back

                  }
                 }catch(Exception ex){}
              }    
           }.start();




  }