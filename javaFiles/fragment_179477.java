for (int i=0; i<workers.length; i++)
{
    int index =workers[i].getIDNum()%100;
    ArrayList target=list.get(index);
    target.add(workers[i]);
}
return list;