public <T extends Food> RecyclerAdapter(Activity activity, List<T> items) {
    this.activity = activity;
    this.items = new ArrayList<>();
    for (Food item : items) {
        this.items.add(item);
    }
}