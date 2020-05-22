String str = "<form action=''><span> First Name </span> <input type='text' id='fname' class='cls' size='40' required /> <span> [*]</span> <input type='submit' value='Submit' name='btn' /> <select name='slcEle' > <option value='opt'> Text</option> </select> <input type='radio' id='this'/> <button name='name' type='reset' value='val'> Text</button> <input type='range' min='0' max='100' name='grade'/> <button name='btnname' type='button'> Text</button>";

String[] separateStrings = str.split("(?<=>)|(?=</)");

int len = separateStrings.length;
for (int i = 0; i < len; i++) {
    System.out.format("[%d] = %s\n", i, separateStrings[i]);
}