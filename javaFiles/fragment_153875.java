String strFormat = "RegNo. {0}\tName {1}\tIC {2}\tPlate No. {3}\tColor {4}\tYear {5}\tMake {6}\tModel {7}\tCapacity {8}\tType {9}\tMax Load {10}");

int counter = 0;

while (rs.next()) {
    counter++;

    regno = rs.getInt("regno");
    name = rs.getString("name");
    ic = rs.getString("ic");
    plate = rs.getString("plate");
    color = rs.getString("color");
    year = rs.getInt("year");
    make = rs.getString("make");
    model = rs.getString("model");
    capacity = rs.getDouble("capacity");
    type = rs.getString("type");
    maxload = rs.getDouble("maxload");

    System.out.println(MessageFormat.format(strFormat, regno, name, ic, plate, color, year, make, model, capacity, type, maxload));
}

if (counter == 0) {
    System.out.println("IC and PLate No. not found....");
}