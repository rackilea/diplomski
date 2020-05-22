Function<BusinessObject, Function<SomeDiscriminator, Function<String, BusinessObject>>> setNewValueInBusinessObjectWithFun =
    new Function<BusinessObject, Function<SomeDiscriminator, Function<String, BusinessObject>>>() {
        @Override
        public Function<SomeDiscriminator, Function<String, BusinessObject>> apply(final BusinessObject businessObject) {
            return new Function<SomeDiscriminator, Function<String, BusinessObject>>() {
                @Override
                public Function<String, BusinessObject> apply(final SomeDiscriminator someDiscriminator) {
                    return new Function<String, BusinessObject>() {
                        @Override
                        public BusinessObject apply(final String newValue) {
                            if (someDiscriminator.value.equals("firstField")) {
                                businessObject.firstField = newValue;
                            } else {//secondField
                                businessObject.secondField = newValue;
                            }
                            return businessObject;
                        }
                    };
                }
            };
        }
    };