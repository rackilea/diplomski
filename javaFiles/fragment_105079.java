package jdk.conf;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args)
    {
        Test01 test01 = new Test01();
        System.out.println(test01.isSubString("abcd", "a*c"));
        System.out.println(test01.isSubString("abcd", "bcd"));
        System.out.println(test01.isSubString("abcd", "*b"));
        System.out.println(test01.isSubString("abcd", "ac"));
        System.out.println(test01.isSubString("abcd", "bd"));
        System.out.println(test01.isSubString("abcd", "b*d"));
        System.out.println(test01.isSubString("abcd", "b\\*d"));
        System.out.println(test01.isSubString("abcd", "\\*d"));
        System.out.println(test01.isSubString("abcd", "b\\*"));

        System.out.println(test01.isSubString("a*cd", "\\*b"));
        System.out.println(test01.isSubString("", "b\\*"));
        System.out.println(test01.isSubString("abcd", ""));

        System.out.println(test01.isSubString("a*bd", "\\*b"));
    }
    // only for non empty Strings
    public boolean isSubString(String string1,String string2)
    {
        // step 1: split by *, but not by \*
        List<String>list1 = new ArrayList<String>();
        char[]cs = string2.toCharArray();
        int lastIndex = 0 ;
        char lastChar = 0 ;
        int i = 0 ;
        for(; i < cs.length ; ++i)
        {
            if(cs[i]=='*' && lastChar!='\\')
            {
                list1.add(new String(cs,lastIndex,i-lastIndex).replace("\\*", "*"));
                lastIndex = i + 1 ;
            }
            lastChar = cs[i];
        }
        if(lastIndex < i )
        {
            list1.add(new String(cs,lastIndex,i-lastIndex).replace("\\*", "*"));
        }
        // step 2: check indices of each string in the list
        // Note: all indices should be in proper order.
        lastIndex = 0;
        for(String str : list1)
        {
            int newIndex = string1.indexOf(str,lastIndex);
            if(newIndex < 0)
            {
                return false;
            }
            lastIndex = newIndex+str.length();
        }
        return true;
    }
}