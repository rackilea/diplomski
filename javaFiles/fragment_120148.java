while(rs.next())
{
    name = records.getString("name");
    surname = records.getString("surname");

    People peo= new People(name,surname);
    peoList.add(peo);

}