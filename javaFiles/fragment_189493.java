String id1 = "";
for (HasName n : set) {
  id1 = n.getName();
  if (id1.equalsIgnoreCase("ABC")) { return id1; }
}
return id1;