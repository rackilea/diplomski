con.setAutocommit(false);
PreparedStatement ps=con.prepareStatement("INSERT INTO "+sname+" VALUES    (?,?,?,?,?,?,?,?,?)");
int counter = 0;
while((newl=bfr.readLine())!=null)
{
    newl.trim();
    String entries[]=newl.split(",");

    String date=entries[0];

    float open=Float.parseFloat(entries[1]);
    float high=Float.parseFloat(entries[2]);
    float low=Float.parseFloat(entries[3]);
    float close=Float.parseFloat(entries[4]);
    int volume=Integer.parseInt(entries[5]);
    float adjclose=Float.parseFloat(entries[6]);
    float amt_change=close-open;
    float percent_change=(amt_change/open)*100;


    ps.setString(1, date);
    ps.setFloat(2, open);
    ps.setFloat(3, high);
    ps.setFloat(4, low);
    ps.setFloat(5, close);
    ps.setInt(6, volume);
    ps.setFloat(7, adjclose);
    ps.setFloat(8, amt_change);
    ps.setFloat(9, percent_change);
    ps.executeUpdate();
    counter++;

    // Try with values different of 1000 to check the best commit size.
    // It depends from the database, the hardware, the record size
    if (counter % 1000 == 0) {
        conn.commit();
    }
}
conn.commit();   // Remember to add a final commit