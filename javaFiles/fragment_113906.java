Message PhoneBook {
    repeated Person people = 1;
}
Message Person {
    required Name name = 1;
    optional String phone = 2;
}
Message Name {
    required String family_name = 1;
    required String given_name = 2;
}