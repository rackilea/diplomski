List<CustomField> list = getList();
ListBackedMap<CustomField, String, String> map = new ListBackedMap<>(
        list,
        (key, value) -> new CustomField(key, value),
        CustomField::getKey,
        CustomField::getValue);