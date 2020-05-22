// simplified way of identifying tag by first byte of it,
// make it more complex as needed
byte startOfTag = 65;

// for loop assumes tags start at even 4 byte boundary, if not, modify loop
for(int i = 0; i <= data.length-4 ; i += 4) {
    if (data[i] == startOfTag) {
        myTagHandlerMethod(data[i], data[i+1], data[i+2], data[i+3]);
    }
}