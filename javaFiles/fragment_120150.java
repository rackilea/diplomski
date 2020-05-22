final static Logger LOG = Logger.getLogger(myClass.class.getName());

ResultSet rs = null;

try {
    rs = stat.executeQuery("SELECT * from people WHERE surname='"+surname+"'");
} catch (SQLException ex) {
    LOG.severe("", ex);
}

String name, surname;
List<People> peoList = new ArrayList<People>();

try {
    while(rs.next()) {
        name = rs.getString("name");
        surname = rs.getString("surname");

        People peo= new People(name,surname);
        peoList.add(peo);

    }
} catch (SQLException ex) {
    LOG.severe("", ex);
} 

return peoList;