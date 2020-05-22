String line;
int i = 0;
while(!(line = userInput.nextLine()).isEmpty()) {
    for (String word :line.split("\\s+")){
        stringArray[i]=word;
        i++;
    }
}