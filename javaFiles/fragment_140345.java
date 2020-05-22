String s = "I am enouuugGh of an artis t to draw         freely upon my imagination. ImaginatioOO n is more importan t than      knowledge. KKkKkKnowledge is limited. Imagination encircles the wwWorl d.";
System.out.println(s);
System.out.println("========================================================");
s = s.replaceAll("\\s+"," ");
s = s.replaceAll("(?i)(\\w)\\1+","$1");
s = s.replaceAll("(\\w+) (\\w)(?=[ \\.\\?!,])","$1$2");
System.out.println(s);