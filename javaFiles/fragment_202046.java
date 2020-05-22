private final int N = 5;

// 2 rows in one array [0..N-1, N..2N-1]
private int[] board = new int[2 * N];

// found solution counter
int found = 0;

/*
 * this method set next number to current position
 * and recursively go to next position.
 */
public void check(int position) {

    // if board is complete - check if valid
    if (position == 2 * N) {
        if (isValid()) {
            System.out.println("foun : " + Arrays.toString(board));
            found++;
        }
        return;
    }


    // if board is not complete - put all numbers (0..N) into current position
    // and recursively go to next position
    for (int v = 0; v <= N; v++) {
        board[position] = v;

        // if solution is already broken - step backwards
        // see: backtracking algorithms
        if (isBroken(position)) {
            return;
        }

        check(position + 1);
    }
}

public boolean isValid() {

    // condition 1
    int sum = 0;
    for (int i = 0; i < board.length; i++) {
        sum += board[i];
    }
    if (sum != N) {
        return false;
    }

    // conditin 2
    int prev = board[0];
    for (int i = 1; i < N; i++) {
        if (board[i] > prev) {
            return false;
        }
        prev = board[i];
    }
    prev = board[N];
    for (int i = N + 1; i < 2 * N; i++) {
        if (board[i] > prev) {
            return false;
        }
        prev = board[i];
    }

    // condition 3
    for (int i = 0; i < N; i++) {
        int top = board[i];
        int bottom = board[i + N];
        if (top < bottom) {
            return false;
        }
    }

    // valid
    return true;
}

// simplified version of this method - but correct
public boolean isBroken(int current) {
    int sum = 0;
    for (int i = 0; i <= current; i++) {
        sum += board[i];
    }
    return sum > N;
}

public void start() {
    check(0);
    System.out.println("found: " + found);
}