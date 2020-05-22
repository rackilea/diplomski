// members is an ArrayList of Member objects

HashMap<String, ArrayList<ArrayList<String>>> dobMap = new HashMap<>();
for (Member m : members) {
    String[] temp = {m.getName(), m.getNo()}; // e.g. [Dave, 40]
    // already in the map, so just push it to the existing ArrayList in there
    if (dobMap.containsKey(m.getDOB())) {
        dobMap.get(m.getDOB()).add(temp); // e.g. [[Dave, 40]].add([Sam, 24])
    } else { // not in the map yet, so push a new ArrayList to that spot
        ArrayList<String[]> temp2 = new ArrayList<>();
        temp2.add(temp); // e.g. [[Dave, 40]]
        dobMap.put(m.getDOB(), temp2);
    }
}