Class Parent{
  private int id;
  Set<Child> childSet;
}

Class Child{
  private ChildId childId;
  private String name;
}

Class ChildId{
  private int childKey;
  @JsonBackReference 
  private Parent parent;
}