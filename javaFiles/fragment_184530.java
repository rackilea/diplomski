DataOutputStream out = new DataOutputStream(
    new BufferedOutputStream(
        new FileOutputStream("~/myfile")));
// Write in ASCII
out.write("This is a header\n".getBytes());
// Write a 32-bit int
out.writeInt(6);
//Write a float in binary
out.writeFloat(4.5f);

out.flush(); // the buffer.