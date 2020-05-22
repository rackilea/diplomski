Collections2.filter(Arrays.asList(1, 2, 5, 6, 9),
    new Predicate<Integer>(){
        @Override
        public boolean apply(final Integer input){
            return input.intValue() > 5;
        }
    }
);