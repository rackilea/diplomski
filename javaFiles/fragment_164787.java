public void deleteFamilyMember(FamilyMember member) {
  member.mother.children.remove(member);
  member.father.children.remove(member);
  member.partner.children.remove(member);
  for (FamilyMember child:children) {
    if (child.father == member) child.father = null;
    if (child.mother == member) child.mother = null;
    if (child.partner == member) child.partner = null;
  }
  // now all references to this member are eliminated, gc will do the rest.
}