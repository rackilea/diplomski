ArrayList < String > matchedStr = this.regexMatcher(id, kd);
for (String[] fL: finalList) {
 String updatedList = fL[1];
 for (String match: matchedStr) {
  //System.out.println(match);
  if (kd.containsKey(match)) {
   updatedList = updatedList.replace(match, kd.get(match));
   System.out.println(updatedList);
  }
 }
}