String test = "hello my name is mario";

    String result = "";
    int c = 1;
    for (int i = 0; i < test.length(); i++) {
        if (c++==5) {
            result += "X";
            c = 1;
        } else {
            result += test.charAt(i);
        }
    }
    System.out.println("result = " + result);