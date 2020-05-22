while(rs.next())
{
    name = rs.getString("name");
    surname = rs.getString("surname");

    People peo= new People(name,surname);
    peoList.add(peo);

}