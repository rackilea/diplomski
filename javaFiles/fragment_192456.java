public Converter<Object, CustomerPreferences> converter() {
    return new Converter<Object, CustomerPreferences>() {
        @Override
        public CustomerPreferences from(Object t) {
            if (some check here to see if this is a regular customer)
                return new RegularCustomerPreferences(t);
            else
                return new PremiumCustomerPreferences(t);
        }

        @Override
        public Object to(CustomerPreferences u) {
            return MyJSONTools.toJSON(u);
        }

        @Override
        public Class<Object> fromType() {
            return Object.class;
        }

        @Override
        public Class<CustomerPreferences> toType() {
            return CustomerPreferences.class;
        }
    };
}