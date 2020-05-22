public class TemperatureServer extends NanoHTTPD {
    // Loaded and cached html template
    private static String templ;

    // Value of this variable will be included and sent in the response
    private static double temperature;

    public TemperatureServer () {
        super(8080);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String html = templ.replace("[temperature variable]",
            Double.toString(temperature));
        return new NanoHTTPD.Response(html);
    }

    public static void main(String[] args) throws Exception {
        byte[] data = Files.readAllBytes(Paths.get("mytemplpate.html"));
        templ = new String(data, StandardCharsets.UTF_8);

        ServerRunner.run(TemperatureServer.class);
    }
}