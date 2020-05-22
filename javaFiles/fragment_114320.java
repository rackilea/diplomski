boolean loadSuccess=false;
  try
  {
   loadSuccess=loadData1(id1);
  }
  catch(Exception e)
  {
     //error handling or logging code goes here
  }
  if(!loadSuccess)
  {
    try
    {
     loadData2(id2);
    }
    catch(Exception e)
    {
     //error handling or logging code goes here
    }
  }