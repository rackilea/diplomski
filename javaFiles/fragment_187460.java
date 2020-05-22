do {
    temp=din.readUTF();
    ch=Integer.parseInt(temp);

    if (ch!=-1) {
        fileout.write(ch);     
        System.out.write(ch);
    }
} while(ch!=-1);