@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    mSimpleFacebook.onActivityResult(this, requestCode, resultCode, data); 
    super.onActivityResult(requestCode, resultCode, data);
}