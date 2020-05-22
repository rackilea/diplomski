if (currentZipFileSize >= EMAIL_SIZE)
    {
        out.close();
        out = new ZipOutputStream(new FileOutputStream(...));
        currentZipFileSize = 0;
    }