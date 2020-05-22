layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            Category item = mCategories.get(position);
            return item.weight;
        }
    });