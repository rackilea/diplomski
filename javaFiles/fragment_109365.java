boolean hasRows = false;
while(rs.next()){
  hasRows = true;
  // do other stuff required.
}

if(!hasRows)
{
  // do stuff when no rows present.
}