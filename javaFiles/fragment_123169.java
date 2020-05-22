public void initialize() {

    brandSelector.setConverter(new StringConverter<LuggageBrand>() {

        @Override
        public String toString(LuggageBrand luggageBrand) {
            // whatever logic you need here to turn the LuggageBrand object to a string:
            String value = luggageBrand.getXXX();
            return value ;
        }

        @Override
        public LuggageBrand fromString(String text) {
            // this method is not used by the ChoiceBox, so you can just
            return null ;
        }
    });

    // other initialization code...

}