public void jsonWriter(List<Employee> employees, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(employees, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }