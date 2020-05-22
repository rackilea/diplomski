inString = new DataInputStream(new BufferedInputStream(s.getInputStream()));
filename = inString.readUTF();
nome_cartella = inString.readUTF();
...
in = s.getInputStream();
while((i = in.read(b)) >0){