MyDTO firstresult = null;
MyDTO lastresult  = null;
if (!results.isEmpty()) {
    firstresult = results.get(0);//first value
    lastresult = results.get(results.size() - 1);//last value
}