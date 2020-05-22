String str = "or A B C -> D";
    String[] array = str.split(" ");
    List<String> list = Arrays.asList(array);
    String currentString;

    for(int i = 0; i < list.size(); i++)
    {
        currentString = list.get(i);

        if(currentString.length() >1) {
             list.remove(currentString);
        }
    }

     System.out.println(list);