public boolean canBeLinked(Member member) 
{
  return canBeLinked(member, new HashSet<>());
}

private boolean canBeLinked(Member member, Set<Member> visited)
{
  if (this.links.contains(member)) {
      return true;
  }
  else {
    visited.add(this);
    for (Member m : links)
    {
      if (!visited.contains(m)) return m.canBeLinked(member, visited);
    }
  }
  return false;
}