ds.writeBytes(twoHyphens + boundary + end);
ds.writeBytes("Content-Disposition: form-data;" + "name=\"folder\"" + end + end + "/mnt/HD/HD_a2/test/" + end);
ds.writeBytes(twoHyphens + boundary + end);
ds.writeBytes("Content-Disposition: form-data;" + "name=\"Filedata\"; filename=\"");
ds.write(newName.getBytes("UTF-8"));
ds.writeBytes("\"" + end);
ds.writeBytes(end);