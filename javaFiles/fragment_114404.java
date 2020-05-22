Collections.sort(activeConverstions, new Comparator<Conversation>() {
    @Override
    public int compare(Conversation o1, Conversation o2) {
        return Long.compare(o2,getT‌​ime(), o1.getTime());
    }
});