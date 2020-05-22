public class Main {

public static void main(String[] args) {
    ConcurrentLinkedQueue<Employee> employeeQueue = new ConcurrentLinkedQueue<>();

    for (int i = 0; i <= 10; i++) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        long id = new Random().nextLong() & 0xffffffffL;
        employeeQueue.add(new Employee(id, generatedString));
    }


    try {
        while (!employeeQueue.isEmpty()) {

          Gson gson = new GsonBuilder().setPrettyPrinting().create();  


                String jsonEmp = gson.toJson(employeeQueue.remove());

          //  JSONObject json = new JSONObject(employeeQueue.remove());

            URL url = new URL("http://localhost:8080/postgressApp/createEmp");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            try {
                 osw.write(jsonEmp);
               // json.write(osw);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            osw.flush();
            osw.close();    
            os.close();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response from server: " + response.toString());
            }

        }

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

  }
}