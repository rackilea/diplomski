private static final SecureRandom random = new SecureRandom();
    static File generateFile(String prefix, String suffix, File dir)
        throws IOException
    {
        long n = random.nextLong();
        if (n == Long.MIN_VALUE) {
            n = 0;      // corner case
        } else {
            n = Math.abs(n);
        }

        // Use only the file name from the supplied prefix
        prefix = (new File(prefix)).getName();

        String name = prefix + Long.toString(n) + suffix;
        File f = new File(dir, name);
        if (!name.equals(f.getName()) || f.isInvalid()) {
            if (System.getSecurityManager() != null)
                throw new IOException("Unable to create temporary file");
            else
                throw new IOException("Unable to create temporary file, " + f);
        }
        return f;
    }