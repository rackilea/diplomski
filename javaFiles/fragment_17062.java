char ch = data.charAt(counter)

if (ch == ' ') 
    board[i][j] = 0;
else
    board[i][j] = Character.getNumericValue(ch);

counter++;