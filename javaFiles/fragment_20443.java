Parent parent = new Parent();
...
Child c1 = new Child();
...
c1.setParent(parent);

List<Child> children = new ArrayList<Child>();
children.add(c1);
parent.setChildren(children);

session.save(parent);