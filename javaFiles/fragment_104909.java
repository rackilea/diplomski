Names names = new Names();
names.setName("ABC");
names.setPlace("Bangalore");
URL url;
try {
    url = new URL("http://localhost:6080/HttpClientSerializable/HttpPostServlet");
    urlCon = (HttpURLConnection) url.openConnection();

    urlCon.setDoOutput(true); // to be able to write.
    urlCon.setDoInput(true); // to be able to read.

    out = new ObjectOutputStream(urlCon.getOutputStream());
    out.writeObject(names);
    out.close();

    ObjectInputStream ois = new ObjectInputStream(urlCon.getInputStream());
    names = (Names) ois.readObject();
    ois.close();
} catch (IOException e) {
    e.printStackTrace();
}
catch (MalformedURLException e1) {
    e1.printStackTrace();
}