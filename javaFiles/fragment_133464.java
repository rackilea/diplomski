public class StripEmptyLinesReader extends FilterReader {

  private char[] prevChars = new char[3];

  public StripEmptyLinesReader(Reader reader) {
    super(reader);
  }

  @Override
  public int read(char[] buffer, int fromIndex, int length) throws IOException {
    int numChars = 0;
    while (numChars == 0) {
        numChars = in.read(buffer, fromIndex, length);
        if (numChars == -1) {
            return -1;
        }
        int lastIndex = fromIndex;
        for (int i = fromIndex; i < fromIndex + numChars; i++) {
            int charsToSkip = numberOfNewlineCharactersToSkip(buffer[i]);
            switch (charsToSkip) {
                case 0:
                    buffer[lastIndex++] = buffer[i];
                    break;
                case 2:
                    lastIndex--;
                    break;
            }
            prevChars[0] = buffer[i];
            prevChars[1] = (i > 0) ? buffer[i - 1] : '\0';
            prevChars[2] = (i > 1) ? buffer[i - 2] : '\0';
        }
        numChars = lastIndex - fromIndex;
    }
    return numChars;
  }

  private int numberOfNewlineCharactersToSkip(char currentChar) {
    if ((currentChar == '\n' && prevChars[0] == '\n') || (currentChar == '\r' && prevChars[0] == '\r')) {
        return 1;
    }
    if ((currentChar == '\n' && prevChars[0] == '\r' && prevChars[1] == '\n' && prevChars[2] == '\r')) {
        return 2;
    }
    return 0;
  }

  @Override
  public int read() throws IOException {
    char[] buffer = new char[1];
    int result = read(buffer, 0, 1);

    return (result == -1) ? -1 : (int) buffer[0];
  }
}