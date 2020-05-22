File file = new File(PATH_PROFILE + UserHelper.getInstance().getUser().getId() + ".jpg");
try (OutputStream os = new FileOutputStream(file)) {
    os.write(dataBytes);
} catch (Exception e) {
    e.printStackTrace();
}