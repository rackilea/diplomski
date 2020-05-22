lock.readLock().lock();

    File file = new File(filePath);

    // if file is absent or empty return empty list
    if (!file.exists() || file.length() == 0) {
        // lock.readLock().unlock(); // this line is missing
        return new ArrayList<String[]>();
    }