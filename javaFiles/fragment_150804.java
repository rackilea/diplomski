...
while (rs.next()){
    out.print(rs.getInt("ID") + " "); // <-- invalid column identifier
    out.print(rs.getString("animalName") + "  ");
    out.print(rs.getString("char1") + ", ");
    out.print(rs.getString("char2") + ", ");
    out.print(rs.getString("char3") + ", ");
    out.print(rs.getString("char4") + ", ");                               
}
...