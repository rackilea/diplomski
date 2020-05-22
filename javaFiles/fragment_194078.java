File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + "wifip2pshared/" + dirName);
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {
            // Do something on success
        } else {
            // Do something else on failure
        }