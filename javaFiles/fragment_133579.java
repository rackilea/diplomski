List list = new ArrayList();
modifyList(list);
noOp(list);

void modifyList(List l)
{
   l.add("A"); // A is added to list
}

void noOp(List l)
{
   l = null; // No effect to list, you are modifying local variable l.
}