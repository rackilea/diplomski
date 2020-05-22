String[] words = str.split(" "); //splits at spaces
boolean flag = true;
int i, last = words.length - 1;
for(i = 0; i <= last/2; i++){
    if(!words[i].equalsIgnoreCase(words[last - i])){
        flag = false;
        System.out.printf("NOT PALINDROME");
        break;
    }
}

if(flag)
    System.out.printf("PALINDROME");