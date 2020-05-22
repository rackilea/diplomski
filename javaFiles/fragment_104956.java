userChatroomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            AlertDialog.Builder adb = new AlertDialog.Builder(UserInfoActivity.this);
            final String roomName = ((TextView) view).getText().toString();
            adb.setTitle("Delete?");
            adb.setMessage("Are you sure you want to delete " + roomName);
            final int positionToRemove = i;
            adb.setNegativeButton("No", null);
            adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    userChatrooms.remove(positionToRemove);
                    userRoomsRef.child(roomName).removeValue();
                    BaseAdapter adapter = (BaseAdapter) userChatroomListView.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            });
            adb.show();
            return false;
    }