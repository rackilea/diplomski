@Override
public Object [] getElements(Object inputElement)
{
  return array of TopLevelElements object;
}

@Override
public Object [] getChildren(Object parentElement)
{
  if (parentElement instanceof TopLevelElement)
   {
     return array of Level1Element children of the top level element
   }
  else if (parentElement instanceof Level1Element)
   {
     return array of Level2Element children of Level1Element
   }
  else if (parentElement instanceof Level2Element)
   { 
     ... return any level 3 elements
   }

  return new Object[0];  // Unknown tree element
}