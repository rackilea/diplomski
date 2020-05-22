Fruit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ArrayList<myItem> filteredItems = new ArrayList<myItem>();
            for (myItem item : itemList) {
                // Not sure how your myItem class looks like but check category here.
                if ("fruit".equals(item.getCategory())) {
                    filteredItems.add(item);
                }
            }
            adapter.updateContent(filteredItems);
        }
    });