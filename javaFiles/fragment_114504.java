class Parent {

  @OneToMany(mappedBy="parent", cascade=CascadeType.ALL, orphanRemoval=true)
  @OrderColumn(name="childIndex")
  @org.hibernate.annotations.ForeignKey(name = "none")
  public List<Child> getChildren() {
    return children;
  }

}