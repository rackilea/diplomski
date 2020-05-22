Toast mMyToast // declared within the activity class
public void removeItem(View view)
{
    if(mMyToast!=null) mMyToast.cancel() // Avoid null pointer exceptions!
    mMyToast = Toast.makeText(this,"Text",Toast.LENGTH_SHORT);
    mMyToast.show();
}