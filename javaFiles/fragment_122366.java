mAdapter.setOnItemClickListener(new IdAdapter.ClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    Intent intent = new Intent(getActivity(), Chat.class);
                    userId = mUsers.get(position).getUserId(); 
                    intent.putExtra("Recievers_Id", userId);
                    intent.putExtra("Recievers_Name", mName);
                    startActivity(intent);
                }

                @Override
                public void onItemLongClick(int position, View v) {
            Log.d("onItemLongClick", userId);
                }
            });