TableLayout tl;

tl=(TableLayout)findViewById(R.id.layout);

for(int i=0;i<tl.getChildCount();i++){
    View v=tl.getChildAt(i);
if(v instanceof TableRow){

    for(int j=0;j<v.getChildCount();j++){
      View innerView=v.getChildAt(j);
      if(innerView instanceof ImageView){
        imageList.add((ImageView)innerView);
        idList.add(innerView.getId());
       }
    } 
 }

}