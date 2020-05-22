/**
     * Writes a single character.
     * @param c int specifying a character to be written.
     */
    public void write(int c) {
        try {
            synchronized (lock) {
                ensureOpen();
                out.write(c);
            }
        }
        ...
        ...
    }