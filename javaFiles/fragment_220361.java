String myString = "Hello.";
char searchChar = 'l';
int count = 0;

for (int i = 0; i < myString.length(); i++) {
    char c = myString.charAt(i);
    if (c == searchChar) {
        count++;
    }
}

System.out.println(count);