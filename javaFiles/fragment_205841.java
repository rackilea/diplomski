for (Object fromEntityInstance : fromEntityInstances) {

    List<Object> itemObject = new ArrayList<Object>();

    for (Object toEntityInstance : toEntityInstances) {
        boolean matches = true;

        for (String[] prop : depPropMappings) {

            // Get properties related keys
            fromProp = prop[0];
            toProp = prop[1];

            Object fromValue = getInstanceValue(fromProp, fromEntityInstance);
            Object toValue = getInstanceValue(toProp, toEntityInstance);

            // Note: Make sure that fromValue cannot be null. If this cannot be
            // guaranteed, add a check here.
            if (!fromValue.equals(toValue)) {
                // if any value mismatches, we can stop checking the remaining
                // properties.
                matches = false;
                break;
            }
        }

        if (matches) {
            // all properties match
            itemObject.add(toEntityInstance);
        }
    }
}