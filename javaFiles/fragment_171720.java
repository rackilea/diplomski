boolean flag = false;
String textInput = "for example";
int index = 0;
String[] yourArray = {"ak", "example"};
for (int i = 0; i <= yourArray.length - 1; i++) {

    if (textInput.contains(yourArray[i])) {
        flag = true;
        index = i;

    }
}
if (flag) 
   System.out.println("found at index " + index);
else 
   System.out.println("not found ");