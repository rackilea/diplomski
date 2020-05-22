File temp;
try (ObjectInputStream inFromServer =
        new ObjectInputStream(clientimage.getInputStream()) {
    temp = (File) inFromService.readObject();
}
System.out.println("infrom: "  + temp + "\n");