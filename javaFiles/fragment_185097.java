while (sc.hasNext()) {
    String[] numbers = sc.next().split("");
    for (int i = 0; i < numbers.length; i++)
        board[r][i] = Integer.parseInt(numbers[i]);
    r++;
}