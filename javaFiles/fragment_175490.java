//This is for getting Textview and Imageview from custom_listview.xml
RelativeLayout vwParentRow = (RelativeLayout)v.getParent();
TextView child = (TextView)vwParentRow.getChildAt(1);
ImageView btnChild = (ImageView)vwParentRow.getChildAt(3);

//This is for changing image to favorited or no
assert (R.id.like == btnChild.getId()); 

Integer integer = (Integer) btnChild.getTag();
integer = integer == null ? 0 : integer;

switch(integer) {
   case R.drawable.yes:
        btnChild.setImageResource(R.drawable.no);
        btnChild.setTag(R.drawable.no);
        //This is to update database
        mDB.execSQL("UPDATE Channel_Info SET Favourite='no' WHERE name='" + child.getText() + "'");
        break;
   case R.drawable.no:
   default:
        btnChild.setImageResource(R.drawable.yes);
        btnChild.setTag(R.drawable.yes);
        mDB.execSQL("UPDATE Channel_Info SET Favourite='yes' WHERE name='" + child.getText() + "'");
        break;
}