Iterator<Map.Entry<String, ReadTableConnectionInfo >> it = tableLists.entrySet().iterator();
if (r.nextFloat() < Read.percentageTable / 100) {
  table = it.next().getValue();
} else { //since you have an else, you have to re-ignore the first value just below
  it.next(); // ignoring the first value
  table = it.next().getValue(); //repeated here in order to get the second value
}