Function<BusinessObject, Function<SomeDiscriminator, Function<String, BusinessObject>>> setNewValueInBusinessObjectWithFun = 
    businessObject -> someDiscriminator -> newValue -> {
        if (someDiscriminator.value.equals("firstField")) {
            businessObject.firstField = newValue;
        } else {//secondField
            businessObject.secondField = newValue;
        }
        return businessObject;
    };