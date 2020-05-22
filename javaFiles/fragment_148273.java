OutputStream output = new FileOutputStream("your file");

byte[] buffer = new byte[1024];
while ((bytesRead = in.read(buffer)) != -1) {
    output.write(buffer, 0, bytesRead);
}
       JOptionPane.showMessageDialog(null,"File Recieved Sucessfully");