public void importDST(String src) throws IOException{
    try (DataInputStream dit = new DataInputStream(new BufferedInputStream(new FileInputStream(src)))) {
        while (dit.available() > 0) {
            Pupil p = new Pupil();
            byte[] arr;
            int len;

            p.setId(dit.readInt());
            p.setNumber(dit.readInt());
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setFirstname(new String(arr, "ISO-8859-1"));
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setLastname(new String(arr, "ISO-8859-1"));
            p.setGender(dit.readChar());
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setReligion(new String(arr, "ISO-8859-1"));
            p.setDay(dit.readInt());
            p.setMonth(dit.readInt());
            p.setYear(dit.readInt());
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setStreet(new String(arr, "ISO-8859-1"));
            p.setPlz(dit.readInt());
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setLocation(new String(arr, "ISO-8859-1"));
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setShortName(new String(arr, "ISO-8859-1"));
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setClassName(new String(arr, "ISO-8859-1"));
            len = dit.readInt();
            arr = new byte[len];
            dit.readFully(arr);
            p.setKvLastname(new String(arr, "ISO-8859-1"));

            pupils.add(p);
        }
    }
}