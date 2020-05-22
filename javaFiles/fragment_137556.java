// BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
ObjectInputStream objectInput = new ObjectInputStream(connection.getInputStream());
PrintWriter output = new PrintWriter(connection.getOutputStream(), true);

// Read data as follows:    
// String res = input.readLine();
String res = objectInput.readUTF();