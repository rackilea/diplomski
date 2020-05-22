ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
byte[] buf = new byte[1024];

File file;
InputStream in;
// Loop through entities
for (TitleProductAccountApproval tpAccountApproval : tpAccountApprovals) {
    // Generate the file    
    file = xmlManager.getXML(
        tpAccountApproval.getTitleProduct().getTitleProductId(), 
        tpAccountApproval.getAccount().getAccountId(), 
        username);

    // Write to zip file
    in = new FileInputStream(file);
    out.putNextEntry(new ZipEntry(file.getName()));

    int len;
    while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
    }

    out.closeEntry();
    in.close();
}

out.close();