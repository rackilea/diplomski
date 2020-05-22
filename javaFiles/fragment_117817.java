public static long copyLarge(final InputStream input, final OutputStream output, final byte[] buffer)
                throws IOException {
            long count = 0;
            int n = 0;
            while (EOF != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
                count += n;
            }
            return count;
        }