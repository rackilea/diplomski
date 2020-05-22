Map<String, String> args = new HashMap<String, String>();
args.put("objectOne.objectTwo.variableName1", objectOne.objectTwo.variableName1);
args.put(...);
.
.
.
for(int i = 0 ; i < 5 ; ++i) {
   String firstString = "objectOne.objectTwo.variableName" + i;
   String secondString = "objectTwo.objectTwo.variableName" + i;
   if(args.get(firstString) == args.get(secondString))
      //more code
}