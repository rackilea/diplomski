public class FtpToStringConverter implements Converter<FtpConnection, String> {
    @Override
    public String convert(FtpConnection ftpConnection) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(ftpConnection);
        } catch (IOException e) {
            return "{}";
        }
    }
}

public class StringToFtpConverter implements Converter<String, FtpConnection> {
    @Override
    public FtpConnection convert(String s) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new StringReader(s),FtpConnection.class);
        } catch (IOException e) {
            return null;
        }

    }
}