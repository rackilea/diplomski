FileOutputStream fos = null;
    CipherOutputStream cos = null;
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(inputFile);
        fos = new FileOutputStream(outputFile);
        cos = new CipherOutputStream(fos, cipher);
        // once cos wraps the fos, you should set it to null
        fos = null;
        ...
    } finally {
        if (cos != null) {
           cos.close();
        }
        if (fos != null) {
           fos.close();
        }
        if (fis != null) {
           fis.close();
        }
    }