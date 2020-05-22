query.whereEqualTo("ques",/*enter question number here*/);
       query.findInBackground(new FindCallBack<ParseObject>(){
                 public void done(List<ParseObject> l; ParseException e){
                          if(e == null){
                                 for(int i = 0; i <l.size();i++){
                                       textView.setText(l.get(i).getString("optionA"))
                                     }
                               }
                              else{//handle the error
                                        }
    }

});