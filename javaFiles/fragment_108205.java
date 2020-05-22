Class Persons
{
    int     id;
    string  name;
    AddressesCollection addresses;
}

Class Addresses
{
    int     id;
    string  address;
    Persons person;
}