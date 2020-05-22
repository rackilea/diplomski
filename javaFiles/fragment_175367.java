... setup someMap however you want.

List<String> leftKeyList = new LinkedList<String>();
List<String> rightKeyList = new LinkedList<String>();

leftKeyList.addAll(someMap.keySet());
Collections.sort(leftKeyList); // you seem to want the keys sorted.

for (final String leftKey : leftKeyList)
{
    Set<String> rightKeySet = someMap.keySet());

    rightKeySet.remove(leftKey);

    rightKeyList.clear();
    rightKeyList.addAll(rightKeySet);
    Collections.sort(rightKeySet); // you seem to want these keys sorted as well.

    for (final String rightKey : rightSeyList)
    {
        System.out.println(leftKey + "   " + rightKey);
    }
}