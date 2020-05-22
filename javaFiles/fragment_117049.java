Collections.sort(
  arrlstContacts, 
  new Comparator<Contacts>() 
  {
    public int compare(Contacts lhs, Contacts rhs) 
    {
      return lhs.Name.compareTo(rhs.Name);
    }
  }
);