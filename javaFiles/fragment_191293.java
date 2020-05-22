Comparator<Item> comparator = new Comparator<Item>() {

    Map<String, Integer> codes = x.getItemCodeOrder();      
    Map<String, Integer> types = y.getItemTypeOrder(); 
    Map<String, Integer> origins = z.getOriginOrder();

    @Override
    public int compare(Item a, Item b) {

        int byCode = Objects.requireNonNull(codes.get(a.code))
                       .compareTo(Objects.requireNonNull(codes.get(b.code)));

        if (byCode == 0) {
            int byType = Objects.requireNonNull(types.get(a.type))
                           .compareTo(Objects.requireNonNull(types.get(b.type)));

            if (byType == 0) {
                return Objects.requireNonNull(origins.get(a.origin))
                         .compareTo(Objects.requireNonNull(origins.get(b.origin)));

            } else 
                return byType;

        } else 
            return byCode;
    }
};