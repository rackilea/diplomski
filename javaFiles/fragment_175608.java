public Config editObject(BusinessObject object) {
    return modifyObject(object, ConfigBuilder::edit);
}

public Config copyObject(BusinessObject object) {
    return modifyObject(object, ConfigBuilder::copy);
}