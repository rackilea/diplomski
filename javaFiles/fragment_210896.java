String handler = ""; 
String xmlStringReply = "";
for (Feed f: feeds) {
    feedList.add(f);
    handler = "You have successfully added: \n"; 
    xmlStringReply = "" + f + "\n";
}

feedList.save(feedFile);
return handler + xmlStringReply;