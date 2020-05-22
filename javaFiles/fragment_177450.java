String[] temp = ipOrMac.split(ipOrMac.contains(":") ? ":" : "\\.");

byte[] array = new byte[temp.length];

for(int i = 0; i < temp.length; ++i)
    array[i] = (byte)Integer.parseInt(temp[i]);