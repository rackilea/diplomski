public String sqConcat(String string1, String string2)
 {
    String[] rows1 = string1.split("\n");
    String[] rows2 = string2.split("\n");

    return new String(rows1[0] + rows2[0] + "\n"
                    + rows1[1] + rows2[1] + "\n"
                    + rows1[2] + rows2[2] + "\n");
 }