char[] input = ...
char[] reversedInput = new char[input.length];

// Reversely iterate through source
int forwardIndex = 0;
for (int i = input.length - 1; i > 0; i--) {
    reversedInput[forwardIndex] = input[i];
    forwardIndex++;
}