public final class DatabaseUtil {

    private static final String FILE_PATH = "/tmp/db.json";

    private static ObjectMapper objectMapper = new ObjectMapper();

    private DatabaseUtil() {}

    public static List<UserDto> initUserList() throws IOException {
        BulkUserDto dto = objectMapper.readValue(Paths.get(FILE_PATH).toFile(), BulkUserDto.class);
        return dto.getUserDtos();
    }

    public static void saveUserList(BulkUserDto dto) throws IOException {
        String parsedObject = objectMapper.writeValueAsString(dto);
        if (Files.exists(Paths.get(FILE_PATH))) {
            System.out.println("Found old db file under:: " + FILE_PATH + " deleting");
            Files.delete(Paths.get(FILE_PATH));
        }

        FileWriter writer = new FileWriter(Paths.get(FILE_PATH).toFile());
        writer.write(parsedObject);
        writer.flush();
    }

}