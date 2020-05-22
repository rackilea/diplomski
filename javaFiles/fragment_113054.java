char[] letters = {'a','b','c','d','e','f','g','h'
        ,'i','j','k','l','m','n','o','p','q'
        ,'r','s','t','u','v','w','x','y','z'};
Button[] buttons = new Button[26];

for(int i = 0;i< 26;++i){
    buttons[i] = new Button(Character.toString(letters[i])); //need to convert char to String first
    this.add(buttons[i],BorderLayout.SOUTH);
}