setList(ArrayList<Order> items);
    {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }