String array[] = {"please", "help", "me"};
String output = "https://www.google.com/#q=" + Arrays.toString(array).
                    replace("[", "").
                    replace("]", "").
                    replace(", ", "+");
System.out.println(output);