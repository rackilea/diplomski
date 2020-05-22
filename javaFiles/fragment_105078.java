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
            //earlier buggy line:
            //list1.add(new String(cs,lastIndex,i-lastIndex));
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