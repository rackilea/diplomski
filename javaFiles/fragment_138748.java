XStream xs = new XStream(){
        @Override
        public ConverterLookup getConverterLookup() {
            return new ConverterLookup() {

                public Converter lookupConverterForType(Class type) {
                    //Do your magic here
                }
            };
        }
    };