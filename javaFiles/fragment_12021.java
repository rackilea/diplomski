final String FILE_PATH      = "C:\\tmp\\38830664.json"; // use your own!!!

Gson gson = new Gson();
JsonReader reader = new JsonReader(new FileReader(FILE_PATH));
TestRequest data = gson.fromJson(reader, TestRequest.class);

for (Item i :data.result)
    System.out.println(i);