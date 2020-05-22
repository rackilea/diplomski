raf.writeLong(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        raf.writeInt(10);
        raf.writeInt(2);
        raf.write((byte)1);
        raf.writeInt(3);
        raf.close();