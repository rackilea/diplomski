String a = "iaxxai";
String b = "aaxxaaxx";

boolean lastCharacterMatch = false;
int count = 0;

for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
  if (a.charAt(i) == b.charAt(i)) {
    if (lastCharacterMatch) {
      count++;  
    } else {
      lastCharacterMatch = true;
    }
  } else {
    lastCharacterMatch = false;
  }
}

System.out.println(count);