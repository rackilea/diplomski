Map<String, List<WidgetGroup>> widgetGroups = new HashMap<String, List<WidgetGroup>>();
WidgetGroup widgetGroup1 = getWidgetGroup(); // Just an assumption of one of your methods.
WidgetGroup widgetGroup2 = getWidgetGroup(); // Just an assumption of one of your methods.

List<WidgetGroup> widgetGroupList = new ArrayList<WidgetGroup>();
widgetGroupList.add(widgetGroup1);
widgetGroupList.add(widgetGroup2);

widgetGroups.put("widgetGroups", widgetGroupList);