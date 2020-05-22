public interface EmptyListBuilder {

    public <E> List<E> newList();

    public static final EmptyListBuilder ARRAY_LIST_BUILDER = 
            new EmptyListBuilder() {

        public <E> List<E> newList() {
            return new ArrayList<E>();
        }
    };
}