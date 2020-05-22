public String encrypt(String sntnc) { 
     StringBuilder sb = new StringBuilder();
     for (char ch : sntnc.toCharArray()) {
         if (ch == 'm') sb.append("ssad");
         else if (ch == 'b') sb.append("dug>?/");
         else if (ch == 'g') sb.append("jeb..w");
         else if (ch == 'v') sb.append("ag',r");
         else sb.append(ch);
     }
     return sb.toString();
}