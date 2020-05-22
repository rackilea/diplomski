int[] buttonNumbers = new int[characters.size()];
int j = 0;
for (int i = 0; i < but.length; i++){
    for (String s : characters){
        if (but.getText().contains(s)){
            buttonNumbers[j] = i;
            j++;
        }
    }
}