char current = 'w';
int shift = 100;
int alphabetSize = 26; // Or alternatively ('z' - 'a')

int currentAsInt = (int) current;          // Would print: 119
int shiftInRange = shift % alphabetSize;   // Would print: 22
int shifted = currentAsInt + shiftInRange; // Would print: 141 (nothing meaningful)

// If exceeding the range then begin at 'a' again
int shiftCorrected = shifted;
if (shifted > 'z') {
    shiftCorrected -= alphabetSize; // Would print: 115
}

char currentAfterShift = (char) shiftCorrected; // Would print: s