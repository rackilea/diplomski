List<String> seatTypeValues = ...
List<String> modelValues = ...
List<String> backValues = ...
List<String> mechValues = ...

if (seatTypeValues.isEmpty()) { seatTypeValues.add(null); }
... // all 4 lists

for(String seatType : seatTypeValues) {
  for(String model : modelValues) {
    for(String back : backValues) {
      for(String mech : mechValues) {
        // print the CSV
        if (seatType != null) {
          writer.write(seatType);
        }
        if (model != null) {
          writer.write(',');
          writer.write(model);
        }
        if (back != null) {
          writer.write(',');
          writer.write(back);
        }
        if (mech != null) {
          writer.write(',');
          writer.write(mech);
        }
        writer.write("\r\n");
      }
    }
  }
}