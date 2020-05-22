FileInputStream fin = new FileInputStream(new File(path));
BufferedWriter bw = new BufferedWriter(new FileWriter(otherpath));
byte contents[] = new byte[100];
while (fin.read(contents)!= -1)
{
  for (byte b : contents)
    for (int x = 0; x < 8; x++)
      bw.write(b>>x & 1);
}