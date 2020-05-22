StringBuffer sb = new StringBuffer();
for(int i=0;i<columns.size();++i){
sb.append("<tr>");
sb.append("<td>");sb.append(columns.get(i); sb.append("</td>");
sb.append("<td>");sb.append(columns1.get(i); sb.append("</td>");
sb.append("<td>");sb.append(columns2.get(i); sb.append("</td>");
sb.append("<td>");sb.append(columns3.get(i); sb.append("</td>");
... // do same with other arraylist
sb.append("</tr>");
}

 out.println(sb.toString());