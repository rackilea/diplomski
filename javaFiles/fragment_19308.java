Path logFile = Paths.get(this.output_folder + "/" + file.getName().split("\\.")[0] + ".json");
try (BufferedWriter writer = Files.newBufferedWriter(logFile, StandardCharsets.UTF_8)) {
    writer.write("\uFEFF");
    ObjectMapper mapper = new ObjectMapper();
    writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(all_questions));
}