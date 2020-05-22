Collections.sort(activeConverstions, new Comparator<Conversation>() {
    @Override
    public int compare(Conversation o1, Conversation o2) {
        return o2.getTime() > o1.getTime() ? 1 :  o2.getTime() < o1.getTime() ? -1 : 0;
    }
});