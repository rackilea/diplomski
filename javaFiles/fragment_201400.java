Object token = client.invoke("wp.getPost", new Object[]{"0","myusername", "mypassword", 1545, fields });
String[] items = token.toString().split(",");
for (String item : items) {
    String[] parts = item.split("=");
    String key = parts[0];
    String value = parts[1];
    // do stuff with your keys and values here
}