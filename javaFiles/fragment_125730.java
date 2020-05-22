String ticketCheck = "{ \"function\":\"Check\",\"teamId\":IC106-2,\"teamKey\":1b3741ccf6d9ec5245055370125d901e,\"requestId\":1,\"firstName\":\"" + fname + "\" ,\"lastName\":\""+lastName+"\",\"ticketNumber\":\"\"" + ticketnummer + "\"}";

HttpURLConnection con = (HttpURLConnection) object.openConnection();
con.setDoOutput(true);
con.setDoInput(true);
con.setRequestProperty("Content-Type", "application/json");
con.setRequestProperty("Accept", "application/json");
con.setRequestMethod("POST");

OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
writer.write(ticketCheck);
//this line closes the outputstream and actually makes the http request is sent
writer.flush();