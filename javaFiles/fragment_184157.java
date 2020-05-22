Parent parent = session.getParent(id); // id=10
 // Here parent has child object {id: 20, name: "FirstChild"}

 Child newChild = session.getChild(21); 
 parent.setChild(newChild);

 session.update(parent);