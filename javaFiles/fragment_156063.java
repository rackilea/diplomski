public class Report {
  String reportId; // This is important
  String reporterId;  //This is important
  String reporterName;
  String userType;
  String status;
  String address;
  String neibourhood;
  String image;
}

DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Incident Reports");
String reportId = dbRef.push().getKey(); //This generates a new key and returns it
Report report = new Report("report id", "reporter id", "other stuff"... "etc");
dbRef.child(reportId).setValue(report);