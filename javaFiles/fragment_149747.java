@Override
public void sendChangeEvent(int changeType){
 switch(changeType){
    case 0: 
            // Update you UI like above
            // ...
            if(mDrawerList != null){
                mDrawerList.setSelector(R.drawable.list_selector);
            }
       break;
    default: break;
  }

}