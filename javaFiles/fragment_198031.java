GridLayoutManager glm = new GridLayoutManager(getContext(), 20);
    glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            if (position < TotalSeat-5)
                return 5;
            else return 4;
        }
    });