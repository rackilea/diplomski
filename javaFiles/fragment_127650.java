String input = "123";
    String winner = "321";
    char[] inputArr = input.toCharArray();
    Arrays.sort(inputArr);

    char[] winnerArr = winner.toCharArray();
    Arrays.sort(winnerArr);

    boolean retval = Arrays.equals(inputArr, winnerArr);
    System.out.println(retval);