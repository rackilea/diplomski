boolean lala( Student given ) {
  for( Student s : classList ) {
    if( s.getForename().equals( given.getForename() ) &&
        s.getSurname().equals( given.getSurname() ) ) {
      return true;
    }
  }

  return false;
}