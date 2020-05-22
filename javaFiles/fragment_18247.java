List<Elem> withAnOrdering = new ArrayList<>(fromMySetOfElem);
for (int i = 0; i < numTimes; i++)
{
     Collections.shuffle(withAnOrdering);
     //Do something with the ordering

}