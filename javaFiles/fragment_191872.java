@Override
    public void onItemClick(AdapterView parent, View v, int position, long id) {
        List<ContactItemInterface> searchList = inSearchMode ? filterList : contactList ;

        float lastTouchX = listview.getScroller().getLastTouchDownEventX();
        if(lastTouchX < 45 && lastTouchX > -1){
            Toast.makeText(ContactListActivity.this, "User image is clicked ( " + searchList.get(position).getItemForIndex()  + ")", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(ContactListActivity.this, "Nomor: " + searchList.get(position).getItemForIndex() , Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:xxx" ));// replcae "xxx" with the desired number
            startActivity(intent);
        }
   }