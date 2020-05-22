public static void main(String args[]){
    String input = "[-1b,+3XX,-4AA,+1aaa,+20CCa,-9ABa,-9ABaa,+20CCCa,+3BBX,+1aab,+10]";
    String[] array = input.substring(1, input.length() - 1).split(",");
    Arrays.sort(array, new PolynomialComparator());
    System.out.println("[" + String.join(",", array) + "]");
}

OUTPUT: [-4AA,-9ABa,-9ABaa,+3BBX,+20CCCa,+20CCa,+3XX,+1aaa,+1aab,-1b,+10]