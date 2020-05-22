try {
    directory1 = b.getString("directory");
    file_path = directory1;
} catch (Exception e) {
    textField.setText(e.getMessage());
    directory1="returned nothon";
}