class User {
    private Long id;
    private String date;

    public User(Long id, String date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }
}

List<User> listUsers = new ArrayList<User>();
listUsers.add(new User(new Long(2500), "03/05/2013"));
listUsers.add(new User(new Long(2500), "04/05/2013"));
listUsers.add(new User(new Long(2500), "05/05/2013"));
listUsers.add(new User(new Long(200), "10/05/2013"));
listUsers.add(new User(new Long(200), "18/05/2013"));

HashMap<Long, ArrayList> map = new HashMap<Long, ArrayList>();

for(User user : listUsers) {        
    if(map.containsKey(user.getId())) {
        map.get(user.getId()).add(user.getDate());
    } else {
        ArrayList<String> dates = new ArrayList<String>();
        dates.add(user.getDate());
        map.put(user.getId(), dates);
    }
}

//just to check
System.out.println("number of keys : " + map.size());
System.out.println("number of dates for 2500 : " + map.get(new Long(2500)).size());
System.out.println("number of dates for 200 : " + map.get(new Long(200)).size());