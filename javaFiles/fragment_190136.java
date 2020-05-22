if(itr.getItem()==itrfront.getItem())
{
   itrfront = itrfront.getnext();       
   itr.setNext(itrfront);
   continue;       
}