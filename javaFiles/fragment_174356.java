char[] valuetoo = { 'b', 'a', 'c', 'd', 'e'};      
for (char c : valuetoo){
     switch (c){
        case 'a':
            System.out.println("the character found is 'a'");
            break;
        case 'b':
            System.out.println("the character found is 'b'");
            break;
        case 'c':case 'd':case 'e':
            System.out.println("the character found is ");
            break;
        default:
            System.out.println("the characters are not found");
      }
  }