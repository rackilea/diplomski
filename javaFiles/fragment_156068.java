Map<String, List<Property>> myCustomTree = new HashMap<String, List<Property>>();

    Property p1 = new Property();
    p1.setPropertyName("property1");
    p1.setControlType("checkbox");
    p1.setControlValue("TRUE");//may be true/false or checked/unchecked

    Property p2 = new Property();
    p2.setPropertyName("property2");
    p2.setControlType("combobox");
    p1.setControlValue("A String that is contained in my combobox");

    List<Property> properties1 = new ArrayList<Property>();
    properties1.add(p1);
    properties1.add(p2);

    myCustomTree.put("depth1", properties1);