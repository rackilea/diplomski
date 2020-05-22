StringBuilder xmlStringReply = new StringBuilder("You have successfully added: \n");
for (Feed f: feeds) {
    feedList.add(f);
    xmlStringReply.append(f + "\n");
}

feedList.save(feedFile);
return xmlStringReply.toString();