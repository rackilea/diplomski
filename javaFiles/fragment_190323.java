StringBuilder sb= new StringBuilder();
String filter = "";

String[] val=request.getParameterValues("Names");  
for(int i=0;i<val.length;i++){  
 //printval[i];
 sb.append( "'"+val[i]+"'," );
}

filter = sb.ToString();
filter = filter.substring(0, filter.length()-1);

sql =  "where dept_name in("+filter+")";