int result = 0;
    try {
        result = audioInputStream.read(bytes);
    } catch (Exception e) {
        e.printStackTrace();
    }