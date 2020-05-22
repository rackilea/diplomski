if (cNode.hasProperty("states")) {
    Property statesProperty = cNode.getProperty("states");
    if (statesProperty.isMultiple()) {
        Value[] statesValues = states.getValues();
        for (Value stateValue : stateValues) {
            LOG.info(stateValue.getString());
        }
    }
}