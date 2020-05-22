Intent intent = new Intent(this, AddNewActivity.class);
startActivityForResult(intent, REQUEST_ADD_NEW);


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    if (resultCode == RESULT_OK)
    {
        if (requestCode == REQUEST_ADD_NEW_CLOTHING_ITEM)
        {
            gridView.smoothScrollToPosition(0);
        }
    }
}