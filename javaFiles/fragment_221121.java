char[] chars = s.toCharArray();
for(char c: chars){
    if(c >= 0x600 && c <= 0x6ff){
        //Text contains RTL character
        break;
     }
}