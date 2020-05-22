String location = "http://tinyurl.com/so-hints";
HttpURLConnection connection = (HttpURLConnection) new URL(location).openConnection();
connection.setInstanceFollowRedirects(false);
while (connection.getResponseCode() / 100 == 3) {
    location = connection.getHeaderField("location");
    connection = (HttpURLConnection) new URL(location).openConnection();
}
System.out.println(location); // http://msmvps.com/blogs/jon_skeet/archive/2010/08/29/writing-the-perfect-question.aspx