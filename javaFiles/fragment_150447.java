package testCode;

import java.util.List;

import com.google.common.collect.Lists;

public class TestMain {

    static List<String> test1 = Lists.newArrayList();
    static List<String> test2 = Lists.newArrayList("");
    static List<String> test3 = Lists.newArrayList("a");
    static List<String> test4 = Lists.newArrayList("a", "b");
    static List<String> test5 = Lists.newArrayList("a", "b", "c", "d");
    static List<String> test6 = Lists.newArrayList("a", "b", "c", null, "d");
    static List<String> test7 = Lists.newArrayList("a", "b", "c", null);
    static List<String> test8 = Lists.newArrayList("a", "b", "", "", null, "c",
            null);
    static List<String> test9 = Lists.newArrayList("", "a", "b", "c", null);
    static List<String> test10 = Lists.newArrayList(null, "a", "b", "c", null);

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        System.out.println(testClass.joinWithAnd(test1));
        System.out.println(testClass.joinWithAnd(test2));
        System.out.println(testClass.joinWithAnd(test3));
        System.out.println(testClass.joinWithAnd(test4));
        System.out.println(testClass.joinWithAnd(test5));
        System.out.println(testClass.joinWithAnd(test6));
        System.out.println(testClass.joinWithAnd(test7));
        System.out.println(testClass.joinWithAnd(test8));
        System.out.println(testClass.joinWithAnd(test9));
        System.out.println(testClass.joinWithAnd(test10));
    }
}