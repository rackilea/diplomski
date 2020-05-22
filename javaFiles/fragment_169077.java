public boolean equals(ParentClass pa) {
if (!(pa instanceof ChildClass))
    return false;
ChildClass child = (ChildClass) pa;
boolean sameID = ID.equals(child.getID());
return super.equals(child) && sameID;
}