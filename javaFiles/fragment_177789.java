JSONObject jsonObject = new JSONObject();

jsonObject.put("name", nameValue);
jsonObject.put("phoneNumber", phoneNumberValue);
jsonObject.put("emergencyPhoneNumber", emergencyPhoneNumberValue);
jsonObject.put("email", emailValue);

writeFile(context, String.format("%s/%s", context.getFilesDir(), "File name"), jsonObject.toString());

public static void writeFile(Context context, String filePath, String content) throws IOException {

    FileWriter writer = new FileWriter(filePath, false);
    writer.write(content);

    writer.close();

}