HashMap map=new HashMap();
    String[] arr = {"a=z","p=v","l=t","e=m"};
    String text="apple";
    for (int i = 0; i < arr.length; i++) {
        String string = arr[i];
        String replace=string.split("=")[0];
        String replaceWith=string.split("=")[1];
        map.put(replace,replaceWith);
    }
    String newString="";
    char[] chars = text.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        if(map.keySet().contains(String.valueOf(c)))
            newString+=map.get(String.valueOf(c));
        else
            newString+=c;
    }

    System.out.println(newString);