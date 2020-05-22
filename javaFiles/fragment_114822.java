public void onHeartPress(View imgB,int pos)
{
    Log.d("Postion",pos);
     yourArray[pos] = true;
     // if you want to change the others to false;
     for(int i = 0; i < yourArray.length(); i++{
           if( i != pos ){
           yourArray[pos] = false;
            }} 
    notifyItemChanged(pos)
}