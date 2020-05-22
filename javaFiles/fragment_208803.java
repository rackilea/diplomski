MyFunction<BusinessObject, SomeDiscriminator, String> myFunction = 
    (businessObject, someDiscriminator, newValue) -> {
        if (someDiscriminator.value.equals("firstField")) {
            businessObject.firstField = newValue;
        } else {
            businessObject.secondField = newValue;
        }
        return businessObject;
    };

BusinessObject businessObject = new BusinessObject("oldValue");
myFunction.apply(businessObject, new SomeDiscriminator("firstField"), "newValue");