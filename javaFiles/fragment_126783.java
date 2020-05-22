Set<String> registeredPhoneNumbers = new HashSet<>();
for (Contact c : registered_users) {
  registeredPhoneNumbers.add(c.getPhone());
}
List<Contact> common_contacts = new ArrayList<>(phone_contacts);
for (Iterator<Contact> iter = common_contacts.iterator(); iter.hasNext();) {
  Contact c = iter.next();
  if (!registeredPhoneNumbers.contains(c.getPhone())) {
    iter.remove();
  }
}