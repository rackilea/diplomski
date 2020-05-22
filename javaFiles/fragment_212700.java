List<MultiSelectItem> checkedData = adapter.list;
            Log.e("string results", "string results " + getMultiSelectItem().size());
            for(MultiSelectItem item :checkedData) {
                if(item.isSelected()) {
                    Log.e("checker", item.getName());
                }
            }