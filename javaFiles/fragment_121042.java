if (name.equals("title")) {
    result = readTitle(parser);                 
} else if (name.equals("link")) {
    links.add(readLink(parser));
} else {
    skip(parser);
}