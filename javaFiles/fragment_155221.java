gridview_withimage.setAdapter(mainActivityAdapter);
gridview_withimage.postDelayed(new Runnable() {

 @Override
  public void run() {
 // TODO Auto-generated method stub
    ArrayList<String> arrNewList=mainActivityAdapter.getModifyList();           
  }
 }, 100);