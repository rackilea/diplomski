holder.setTag(itemInfo); // Set the tag on the root view rather than the avatarView
.
.
.
.
    OnItemClickListener listener = new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Object object = v.getTag();
                    if (object instanceof KnoteUiItem) {
                        KnoteUiItem uiItem = (KnoteUiItem) object;

                     Log.d("tag","avatar click");
                    }
                }
            };

     mListView.setOnItemClickListener(listener);