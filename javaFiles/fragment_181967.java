StringBuilder builder = new StringBuilder("Results: ");
builder.append(countUppercase(test1)).appende(" ").
    append(countUppercase(test2)).appende(" ").
    append(countUppercase(test3)).appende(" ").
    append(countUppercase(test4));
System.out.println( builder);