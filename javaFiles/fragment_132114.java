while (inputStream.available() > 0) {
     int i = inputStream.read(tmp, 0, 1024);
     if (i < 0)
          break;
     strBuff.append(new String(tmp, 0, i));
}