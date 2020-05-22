public static boolean setSkin(GameProfile profile, UUID uuid) {
    try {
        HttpsURLConnection connection = (HttpsURLConnection) new URL(String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", UUIDTypeAdapter.fromUUID(uuid))).openConnection();
        if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
            String reply = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            String skin = reply.split("\"value\":\"")[1].split("\"")[0];
            String signature = reply.split("\"signature\":\"")[1].split("\"")[0];
            profile.getProperties().put("textures", new Property("textures", skin, signature));
            return true;
        } else {
            System.out.println("Connection could not be opened (Response code " + connection.getResponseCode() + ", " + connection.getResponseMessage() + ")");
            return false;
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}