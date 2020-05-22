private int mCurrentIndex = 1;
 public void setCurrentIndex(int newValueFormCurrentIndex)
 {
   if(newValueFormCurrentIndex != mCurrentIndex)
    {
     onCurrentIndexValueChange();
     mCurrentIndex = newValueFormCurrentIndex;
    }
 }