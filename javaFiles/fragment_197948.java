for (char ch : text.toCharArray()) { 
  switch(ch) {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
      vowelCount++;
      break;
    default:
      consonanyCount++;
      break;
  }
} 
System.out.println("VowelCount : " + vowelCount);
System.out.println("ConsonantCount is : " + consonantCount);