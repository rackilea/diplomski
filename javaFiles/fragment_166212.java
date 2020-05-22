@Override
 public void setVisible(boolean bVisible)
 {
     if(bVisible == false)
     {
         super.setVisible(bVisible);
         return;
     }

     initMyValues();
     super.setVisible(bVisible);
     return;
 }