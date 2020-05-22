public class ProviderTypeWrangler {

    public String getProvider(String json) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            Integration integration;
            integration = mapper.readValue(json, Integration.class);
            return integration.getProvider();
        } catch (JsonParseException e) {
            return "";
        } catch (JsonMappingException e) {
            return "";
        } catch (IOException e) {
            return "";
        }

    }

}