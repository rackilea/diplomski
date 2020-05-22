StringBuilder sb=new StringBuilder();
while(!group.isEof()) {
String groupname1=group.getFieldValueString(USER_GROUP);
sb.append(";"+groupname1);
group.moveNext();
}

printOut(USER+sb.toString());