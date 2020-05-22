final String STUDENT_RECORD_URL="https://spreadsheets.google.com/tq";

Builder builder = Uri.parse(STUDENT_RECORD_URL).buildUpon();
builder.appendQueryParameter("txq", "out:JSON");
builder.appendQueryParameter("tq", "select * where ((A= 201))");
builder.appendQueryParameter("key", "1424bS7kU8nJbHdu4QdoAFdIdWDSnmEnj2NqfMb6rPTU");

String finalUri = builder.build().toString();