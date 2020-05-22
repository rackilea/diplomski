String yourString = "Hello";

StringBuilder sb = new StringBuilder(yourString);
sb.insert(2, '_');

System.out.println(sb.toString());