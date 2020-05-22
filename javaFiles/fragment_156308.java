// create an ArrayList
ArrayList strList = new ArrayList();
for (int i=0;i<25; i++){
strList.add(vars.get("student_id_RegEx_" + String.valueOf(i+1)));
}
// sort this ArrayList
Collections.sort(strList);
// use StringBuilder to build String from ArrayList
StringBuilder builder = new StringBuilder();
for (String id: strList){
builder.append(id);
builder.append(",");
}
builder.deleteCharAt(builder.length()-1);
// finally put in variable using JMeter built in 'vars.put'
// do not use vars.putObject, as you can not send object as request parameter
vars.put("sortedVar", builder.toString());