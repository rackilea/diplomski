char[] input = ...

// Iterate in place, from both sides at one time
int fromFront = 0;
int fromEnd = input.length - 1;

while (fromFront < fromEnd) {
    // Swap elements
    char temp = input[fromEnd];
    input[fromEnd] = input[fromFront];
    input[fromFront] = temp;

    fromFront++;
    fromEnd--;
}