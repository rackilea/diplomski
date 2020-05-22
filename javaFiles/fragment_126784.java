Set<String> phoneNumbers = new HashSet<>();
for (Contact c : phone_contacts) {
    phoneNumbers.add(c.getPhone());
}

Set<String> overlappingNumbers = new HashSet<>();
for (Contact registered : registered_users) {
    if (phoneNumbers.contains(registered.getPhone())) {
        overlappingNumbers.add(registered.getPhone());
    }
}
List<Contact> common_contacts = new ArrayList<>();
for (Contact contact : phone_contacts) {
    if (overlappingNumbers.contains(contact.getPhone())) {
      common_contacts.add(contact);
    }
  }
}