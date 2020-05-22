try(FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(employees, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }