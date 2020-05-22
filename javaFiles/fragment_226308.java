public void downloadFile(String file_name) throws IOException {

    URL url = new URL(file_url + file_name);
    URLConnection connection = url.openConnection();
    InputStream response = connection.getInputStream();

    FileOutputStream fos = new FileOutputStream(local_file_path + file_name);
    byte data[] = new byte[1024];

    //WHERE'S THE BEEF?

    fos.write(data);
    fos.close();
    response.close();
}