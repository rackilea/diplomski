public void addStaff(StaffMember member) {
   id.put(member.getName(), member);
}

public StaffMember get(String name) {
   // this will return null if the member's name isn't a key in the map.
   return id.get(name);
}