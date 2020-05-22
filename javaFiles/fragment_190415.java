public String toString(String a, String[] b) {
    System.out.println("Input: " + a);
    System.out.print("Output:"); // changed to a print, to avoid newline
    String output = "";
    for (int i = 0; i < b.length; i++) {
        output = output + b[i];
    }
    System.out.println(output); // this was missing
    return output;
}//end toString method