public void add_first (Magazine mag)
{
  MagazineNode node = new MagazineNode (mag);

  // make the new first node point to the current root
  node.next=list;

  // update the root to the new first node
  list=node;
}