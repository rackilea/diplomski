// Define where to connect (doesn't actually connect)
Connection connection = Jsoup.connect("http://example.com");

// Connect to the server and get the page
Document doc = connection.get();

// Extract the value from the page
String authCode = doc.select("input[name='code']").val();

// Add the required data to the request
connection.data("id", "myID")
    .data("username", "myUsername")
    .data("code", authCode);

// Connect to the server and do a post
Connection.Response response = connection.method(Method.POST).execute();