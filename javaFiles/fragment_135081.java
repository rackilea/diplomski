public void writeFile() throws IOException {
    try (Writer writer = new FileWriter("src\\Output.json")) {
            Gson gson = new Gson();
            gson.toJson(NoteArray, writer);
        }
    }
}