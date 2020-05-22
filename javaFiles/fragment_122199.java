File file = new File(Environment.getExternalStorageDirectory(),
                    "test.png");

ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
oos.writeObject(file.getName().getBytes());
oos.flush();

//then send the file