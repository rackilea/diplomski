StringBuilder builder = new StringBuilder();

for(int i=0;i<4;i++)
   {
    builder.append(Integer.parseInt(fip[i],2));
    if(i!=3) builder.append(".");
   }

String abc = builder.toString();

System.out.println(abc); // Should print your IP address...