String str = "cow";
    try { 
    Field value = str.getClass().getDeclaredField("value");
    Field count = str.getClass().getDeclaredField("count");
    Field hash = str.getClass().getDeclaredField("hash");
    Field offset = str.getClass().getDeclaredField("offset");
    value.setAccessible(true);
    count.setAccessible(true);
    hash.setAccessible(true);
    offset.setAccessible(true);
    char[] newVal = { 'c','o','w',' ','h','o','r','s','e' };
    value.set(str,newVal);
    count.set(str,newVal.length);
    hash.set(str,0);
    offset.set(str,0);
    } catch (NoSuchFieldException e) {
    } catch (IllegalAccessException e) {}
    System.out.println(str);
}