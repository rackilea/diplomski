StringBuilder sb = new StringBuilder();
for(char c : in.toCharArray())
   if(c > 127)
       sb.append("\\").append(String.format("%04x", (int) c));
   else
       sb.append(c);