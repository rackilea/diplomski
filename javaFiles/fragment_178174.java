private Map<String, List<String>> selectMap = new HashMap<>();
//getter and setter here

@Action("multipleSelect")
public String multipleSelect() {
    vegetables.add("tomato");
    vegetables.add("potato");

    devices.add("mouse");
    devices.add("keyboard");

    selectMap.put("vegetables", vegetables);
    selectMap.put("devices", devices);

    return SUCCESS;
}