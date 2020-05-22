HashMap<String, ArrayList<ArrayList<String>>> dobMap = new HashMap<>();
for (Member m : members) {
    ArrayList<String> temp = new ArrayList<>();
    temp.add(m.getName());
    temp.add(m.getNo());
    if (dobMap.containsKey(m.getDOB())) {
        dobMap.get(m.getDOB()).add(temp);
    } else {
        ArrayList<ArrayList<String>> temp2 = new ArrayList<>();
        temp2.add(temp);
        dobMap.put(m.getDOB(), temp2);
    }
}