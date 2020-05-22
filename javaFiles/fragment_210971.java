String[] cc;
String[] bcc;
if(emailCC.length() != 0){
    cc = emailCC.trim().split(",");
}else if(emailBCC.length() != 0){
    bcc = emailBCC.trim().split(",");
}