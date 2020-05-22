String[] arr = keyword.split("\\s+");
 StringBuilder sb = new StringBuilder();
 for(int i=start;i<=end;i++){
     sb.append(arr[i]).append(" ");
 }
 return sb.toString().trim();