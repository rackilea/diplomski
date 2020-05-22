InputStream in = ... //our byte array as inputstream
byte header = (byte)in.read();
int length = in.read();
byte commandKey = (byte)in.read();   
byte[] data = new byte[length]
in.read(data);

Command command = commands.get(commandKey);
command.execute(data);