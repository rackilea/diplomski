public static void main(String[] args) {

    int[][] identitiesBunch = new int[][] { 
        {2, 1, 1, 1, 2, 2},
        {2, 1, 1, 1, 3, 1},
        {2, 1, 1, 2, 1, 2},
        {2, 1, 1, 2, 2, 1},
        {2, 1, 1, 3, 1, 1} 
    };

    String mine = "123456789";
    char[] numbers = mine.toCharArray();

    int index = 0;
    for (int[] identities: identitiesBunch) {
        for (int id: identities ) {
            for (int i = 0 ; i < id; i++)
                System.out.print(numbers[index++]);
            System.out.print(' ');
        }
        index = 0;
        System.out.println();
    }
}