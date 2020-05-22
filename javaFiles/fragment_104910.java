ObjectInputStream in = new ObjectInputStream(request.getInputStream());
try {
    names = (Names) in.readObject();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
in.close();
ObjectOutputStream out = new ObjectOutputStream(
    new FileOutputStream("C:/Documents and Settings/RAGASTH/Desktop/Names"));
out.writeObject(names);
out.close();

ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
oos.writeObject(names);
oos.close();