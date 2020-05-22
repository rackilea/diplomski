public class SerializableFile implements Serializable {
    private static final File TEMP_DIR = getTempDir();

    private transient boolean temporary;
    private transient String name;
    private transient File file;

    public SerializableFile() {
    }

    public SerializableFile(File file) {
        this.file = file;
        this.name = file.getName();
        this.temporary = false;
    }

    @Override
    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
    }

    public void dispose() {
        if (temporary && file != null) {
            file.delete();
            file = null;
        }
    }

    public File keep(String name) throws IOException {
        if (temporary) {
            temporary = false;
        } else {
            File newFile = new File(TEMP_DIR, name);
            keepAs(newFile);
            file = newFile;
        }
        return file;
    }

    public void keepAs(File outFile) throws IOException {
        if ((temporary || file.equals(outFile)) && file.renameTo(outFile)) {
            temporary = false;
            file = outFile;
        } else {
            InputStream in = new FileInputStream(file);
            try {
                OutputStream out = new FileOutputStream(outFile);
                try {
                    byte buf[] = new byte[4096];
                    for (int n = in.read(buf); n > 0; n = in.read(buf)) {
                        out.write(buf, 0, n);
                    }
                } finally {
                    out.close();
                }
            } finally {
                in.close();
            }
            outFile.setLastModified(file.lastModified());
        }
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public long lastModified() {
        return file.lastModified();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        int size = (int)file.length();
        long date = file.lastModified();
        out.writeUTF(name);
        out.writeInt(size);
        out.writeLong(date);
        InputStream in = new FileInputStream(file);
        try {
            byte buf[] = new byte[4096];
            while (size > 0) {
                int n = in.read(buf);
                if (n <= 0 || n > size) {
                    throw new IOException("Unexpected file size");
                }
                out.write(buf, 0, n);
                size -= n;
            }
        } finally {
            in.close();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException {
        name = in.readUTF();
        int size = in.readInt();
        long date = in.readLong();
        file = File.createTempFile("tmp", ".tmp", TEMP_DIR);
        OutputStream out = new FileOutputStream(file);
        try {
            byte buf[] = new byte[4096];
            while (size > 0) {
                int n = in.read(buf, 0, size <= buf.length ? size : buf.length);
                if (n <= 0 || n > size) {
                    throw new IOException("Unexpected file size");
                }
                out.write(buf, 0, n);
                size -= n;
            }
        } finally {
            out.close();
        }
        file.setLastModified(date);
        temporary = true;
    }

    private static File getTempDir() {
        File dir;
        String temp = System.getProperty("com.lagalerie.live.temp-dir");
        if (temp != null) {
            dir = new File(temp);
        } else {
            String home = System.getProperty("user.home");
            dir = new File(home, "temp");
        }
        if (!dir.isDirectory() && !dir.mkdirs()) {
            throw new RuntimeException("Could not create temp dir " + dir);
        }
        return dir;
    }
}