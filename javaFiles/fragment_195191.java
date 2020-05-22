public class MyClass
{
    private static HashMap<Character, String> myMap = createMyMap();

    private static HashMap<Character, String> createMyMap() {
        HashMap<Character, String> myTmpMap = new HashMap<Character, String>();
        for (int i=0; i < KEYS.length; i++) {
            myTmpMap.put(KEYS.charAt(i), DATA[i]);
        }
        return myTmpMap;
    }
}