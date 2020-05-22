openDialog("This is a title", 
           new OnOk(){
           @Override
           hereIsYourText (String text){
                //I ll log it
                Log.i("Texting",text);
           }});