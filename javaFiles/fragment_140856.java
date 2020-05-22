for(int code; (code = dis.read()) != -1;) {
   switch(code) {
      case 'S':
            String s = dis.readUTF();
            process(s);
            break;
      case 'i':
            int i = dis.readInt();
            process(i);
            break;
      default:
            throw new StreamCorruptedException("code: "+code);
   }