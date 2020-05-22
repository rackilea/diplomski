String response = "Ответ от сервера на русском языке"; //"Response from server in Russian"
byte[] response_data = response.getBytes("UTF-8");
t.sendResponseHeaders(200, response_data.length());
OutputStream os = t.getResponseBody();
os.write(response_data);
os.close();