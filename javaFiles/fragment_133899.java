public class ReplaceTest {

public static void main(String[] args) {
    String str = "Life is practical";  //At first
    testReplace(str);

    str = "I have Life"; //At last
    testReplace(str);

    str = "I have Life, Life is beautiful"; //in the mid
    testReplace(str);


}

private static void testReplace(String str) {
    String[] strArr = str.split("Life");
    StringBuilder newStr = new StringBuilder(strArr[0]);
    for (int i = 1; i < strArr.length; i++) {
        newStr.append("Everything").append(strArr[i]);
    }

    if (str.endsWith("Life")) {
        newStr.append("Everything");
    }
    System.out.println(newStr.toString());

}

}