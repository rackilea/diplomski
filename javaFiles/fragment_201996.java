String text =
        "- I am string one\n" +
        "-I am string two\n" +
        "- I am string-three\n" +
        "with new line\n" +
        "-I am string-four\n" +
        "- I am string five";

String[] split = text.replaceAll("\\R(?!-)", " ") 
                     .replaceAll("(?<=\\R|^)-\\s*","") 
                     .split("\\R");
for (String s: split){
    System.out.println("'"+s+"'");
}