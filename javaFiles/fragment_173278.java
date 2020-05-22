for (Persons person: personSet) {
  Integer reference = pers.get( person.getPersonNumber() );
  if( reference != null ) {
    person.setReference( reference );
  }
}