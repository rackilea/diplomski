@Override
   public boolean onItemLongClick(AdapterView<?> arg0, View arg1, 
                                        int arg2, long arg3) 
      {
         //show dialog menu options box
         AlertDialog dialog=dialogshowOpetionMenu(arg2);//<<pass selected index
         dialog.show(); 
         return true;
     }