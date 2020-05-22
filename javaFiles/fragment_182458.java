private static final int BUFFER_SIZE = 65536;

private static enum InputState { START, MIDDLE }

public static void main(final String[] args) throws IOException {
    // Input the numbers
    final byte[] inputBuffer = new byte[BUFFER_SIZE];
    final List<Integer> inputs = new ArrayList<>();

    int inputValue = 0;
    InputState inputState = InputState.START;

    while (true) {
        int j = 0;
        final int bytesRead = System.in.read(inputBuffer, 0, BUFFER_SIZE);
        if (bytesRead == -1) {
            if (inputState == InputState.MIDDLE) {
                inputs.add(inputValue);
            }
            break;
        }

        for (int i = 0; i < bytesRead; i++) {
            byte ch = inputBuffer[i];
            int leftToken = 0;
            if (ch < 48 || ch > 57) {
                if (inputState == InputState.MIDDLE) {
                    inputs.add(inputValue);
                    inputState = InputState.START;
                }
            }
            else {
                if (inputState == InputState.START) {
                    inputValue = ch - 48;
                    inputState = InputState.MIDDLE;
                }
                else {
                    inputValue = 10*inputValue + ch - 48;
                }
            }
        }
    }
    System.in.close();

    // Put the numbers into a map
    final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    for (int i = 0; i < inputs.size();) {
        final Integer left  = inputs.get(i++);
        final Integer right = inputs.get(i++);

        final Map<Integer, Integer> rights;
        if (map.containsKey(left)) {
            rights = map.get(left);
        }
        else {
            rights = new HashMap<>();
            map.put(left, rights);
        }

        rights.putIfAbsent(right, rights.size() + 1);
    }

    // Prepare StringBuilder with results
    final StringBuilder results = new StringBuilder();

    for (int i = 0; i < inputs.size();) {
        final Integer left  = inputs.get(i++);
        final Integer right = inputs.get(i++);

        final Map<Integer, Integer> rights = map.get(left);

        results.append(left).append('|').append(right);
        results.append('[').append(rights.get(right)).append(',');
        results.append(rights.size()).append(']').append('\n');
    }

    System.out.print(results);
}