private static List<String> listOfRoles(){
    List<String> list = new ArrayList<String>();
    for(DeviceRole role : DeviceRole.values()) {
        list.add(role.toString());
    }
    return list;
}