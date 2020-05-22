Predicate condition = new Predicate() {
   boolean evaluate(Object sample) {
        return ((Sample)sample).value3.equals("three");
   }
};
List result = CollectionUtils.select( list, condition );