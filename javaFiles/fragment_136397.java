if (!file.exists() || !file.isDirectory()) {
    // handle directory doesnt exist
    // note that "error" is just a string variable you can make it whatever you want
    request.setAttribute("error", "Directory already exists!!!!!");
    // you can output this attribue in your jsp to tell the user there was an error
    request.getRequestDispatcher("Common_Receipt.jsp").forward(request, response);
}
FileOutputStream fos = null;
try {
    File outputFile = new File(file, "prefix"+"-"+"no");
    if(outputFile.exists()) {
        // handle file output already exists
        throw new FileAlreadyExistsException(prefix+"-"+no+".pdf");
    }
    fos = new FileOutputStream( outputFile, false);

    // do your writing to the file here
} catch(FileAlreadyExistsException e) {
    request.setAttribute("error", "your file already exists dummy");
    request.getRequestDispatcher("Common_Receipt.jsp").forward(request, response);
} catch(IOException e) {
    // had a problem writing to the file, you decide how to handle it, or group it with the FileAlreadyExistsException. Note that FileAlreadyExistsException extends IOException so to group then just put
    // your code from the FileAlreadyExistsException block into here
    request.setAttribute("error", "woah something bad happened");
    request.getRequestDispatcher("Common_Receipt.jsp").forward(request, response);
} finnaly {
    if(fos != null) fos.close();
}