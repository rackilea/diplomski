String groupDelim="~!";
String entryDelim="~^";
String pairDelim="=";

String[] groups = X.split(groupDelim);
int groupId = 0;
for(String group:groups){
   String entries = group.split(entryDelim);
   int entryId = 0;
   for(String entry:entries){
      String[] pair = entry.split(pairDelim);
      /* now do stuff with */
      groupId; // for sort order if it matters
      entryId; // for sort order if it matters
      String key = pair[0];
      String value = pair[1]; 
      entryId++;
   }
   groupId++;
}