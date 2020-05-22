for (Map.Entry<String, ArrayList<String>> entry : theAccused.entrySet())
{
   String sListName = entry.getKey();
   ArrayList<String> saAccused = entry.getValue();
   if (saAccused.contains(sAccuser))
   {
      // Fire your logic for when you find a match, which can
      // depend on the list's key (name) as well
   }
}