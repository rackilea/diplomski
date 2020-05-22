StringBuffer sb = new StringBuffer();
sb.append("public final static List<String> myStaticList = java.util.Arrays.asList(");
for (int x=0;x<100;x++){
    sb.append("\""+x+"X\",");
}
for (int x=0;x<100;x++){
    sb.append("\""+x+"Y\"");
    sb.append(x<99 ? "," : ");");
}

System.out.println(sb);