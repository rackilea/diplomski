bool flag = true;
for (int i = 0; i < d.getFornavn().length(); i++) {
    char c = d.getFornavn().charAt(i);  
    if ((!c > 'a' && c < 'z') && !(c > 'A' && c < 'Z') && ( c != ' ' || c != '-')) {
       flag = false;
       break;
    }
}