gridView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                        int position, long a) {
                Item item =(Item) items.get(position);
                int  id = item.getDrawable(); 
                Intent i = new Intent(ActivityName.this, FullImageActivity.class);
                i.putExtra("idkey", id); // pass the id
                startActivity(i);

                }
            });