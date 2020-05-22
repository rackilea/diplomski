Map<String, List<List>> payincash1 = new LinkedHashMap<String, List<List>>();

heads.add((String) row[2]);

List tails = null;
tails = new ArrayList();
tails.add((String) row[0]);
tails.add((String) row[1]);
tails.add((String) row[3]);

System.out.println("heads in dao from iter 1: " + heads);
System.out.println("tails in dao from iter1 on: " + tails);

List master = payincash1.get((String)row[2]);
if (master == null) {

    master = new List();
    payincash1.put((String)row[2], master);

}

master.add(tails);