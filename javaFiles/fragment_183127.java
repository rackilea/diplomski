String input = null;
do {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = '_';
        }
    }
    Play();
    if (scan.hasNextLine()) {
        scan.nextLine();
    }
    System.out.print("Do you want to play a game [Y/N]? ");
    input = scan.nextLine();
} while ("y".equalsIgnoreCase(input));