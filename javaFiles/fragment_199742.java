File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        } else {
            f.createNewFile();
        }
    Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(f), "UTF-8"));
    byte[] bt = jsonData.toString().getBytes("UTF-8");
    out.append(new String(bt));
    out.flush();
    out.close();
    if (f.exists()) {
            PutObjectResult res = s3rwclient
                    .putObject(new PutObjectRequest(bucket, key, f));
    }