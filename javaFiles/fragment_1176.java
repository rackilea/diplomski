StreamTokenizer st = new StreamTokenizer(reader);
st.parseNumbers();
st.eolIsSignificant(true);
st.whitespaceChars(',', ',');

tilePattern = new int[rowCount][columnCount];
int row = 0;
int column = 0;

boolean eof = false;
do {
    int token = st.nextToken();
    switch (token) {
        case StreamTokenizer.TT_EOF:
            eof = true;
            break;
        case StreamTokenizer.TT_EOL:
            row++;
            column = 0;
            break;
        case StreamTokenizer.TT_NUMBER:
            tilePattern[row][column] = (int) st.nval;
            column++;
            break;
    }
} while (!eof);