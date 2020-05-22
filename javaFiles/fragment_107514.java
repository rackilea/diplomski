List<SomeClasss> input = ...;
Set<SomeClass>   output = grep(
    input, 
    new Selector<SomeClass> { 
        public boolean select(SomeClass item) {
            return some-boolean-function-of-item; // decide which items to keep here
        }
    }
);