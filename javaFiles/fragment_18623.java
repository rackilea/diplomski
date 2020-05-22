String content = "(42, 10) d (23, 1) (123, 4) (32, 10) d (12, 9)";
    String[] split = null;

    split = content.replace(")",",").replace("(","").replace("d","d,").replace(" ","").split(",");

    for (String a : split)
    {
        System.out.println(a);
    }