HashMap<String, ArrayList<Member>> dobMap = new HashMap<>();
for (Member m : members) {
    if (dobMap.containsKey(m.getDOB())) {
        dobMap.get(m.getDOB()).add(m);
    } else {
        ArrayList<Member> temp = new ArrayList<>();
        temp.add(m);
        dobMap.put(m.getDOB(), temp);
    }
}