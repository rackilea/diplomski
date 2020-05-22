public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                HistoryItem item = historyItems.get(position);
                switch (index) {
                    case 0:
                        //ToDo edit
                        //Toast.makeText(History.this,"pos "+position+" index "+index,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //ToDo delete

                        historyItems.remove(position);
                        adapter.notifyDataSetChanged();