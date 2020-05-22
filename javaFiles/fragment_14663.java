public void numberFill(View view) {
    int index = (Integer) view.getTag();

    // Do your processing with numbers[index]

    numbers[index] = "new value";

    gridAdapter.notifyDataSetChanged();
}