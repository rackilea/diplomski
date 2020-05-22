/*function perform operation dfor_A.indexOf(item.id);*/
public int getIndexOf(String id,List dfor_A)
{
   for (int i = 0; i < dfor_A.size(); i++) {

     FileIn fi = dfor_A.get (i);
     if (fi.getID().equals (id)) {
       return i;  // this is the index
     }
    }

    return -1;
}