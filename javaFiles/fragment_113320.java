Iterator<String> keyIter = logsToPost.iterator();
while (keyIter.hasNext()) {
    String next = keyIter.next();
    //do something
    keyIter.remove();
}