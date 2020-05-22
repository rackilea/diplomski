Request req = new Request();
List<Request.Custom> clist = new ArrayList<>();
Request.Custom c;

c = req.new Custom();
c.setid("one");
clist.add(c);

c = req.new Custom();
c.setid("two");
clist.add(c);

req.setCustom(clist);