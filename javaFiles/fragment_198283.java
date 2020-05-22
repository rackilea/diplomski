interface EditPersonSession {

    void fetchPerson(PersonId id);
    PersonDetails getCurrentPersonDetails();
    void updatePersonDetail(PersonDetail<?> detail);
    void updatePetDetail(PetDetail<?> detail);
    void updateAddressDetail(AddressDetail<?> detail);
    void save();

}