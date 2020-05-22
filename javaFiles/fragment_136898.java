// You can cast your Firestore document's Timestamp field into a Timestamp object
Timestamp dataTimestamp = (Timestamp) docSnapshot.get("timestamp_field");

// Retrieve a Date from the Timestamp
Date dataDate = dataTimestamp.toDate();

// Define the format your Date should be in
SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MMM.yyyy", Locale.getDefault());

// Create a String in the defined format using your Date
String formattedDate = dateFormat.format(dataDate);