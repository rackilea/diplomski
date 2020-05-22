...
// after that line we have to do more
ormAddress.setOrmPersons(ormPersons);
// we have to assign back reference
for(ORMPerson ormPerson: ormPersons)  {
    ormPerson.setOrmAddress(ormAddress);
}