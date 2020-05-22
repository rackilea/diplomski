<cfscript>
    // Initialize TAR file to generate
    outputPath = "c:/temp/outputFile3.tar";
    os = createObject("java", "java.io.FileOutputStream").init(outputPath);
    tar = createObject("java", "org.apache.commons.compress.archivers.tar.TarArchiveOutputStream").init(os);

    // Add an entry from a string
    someTextContent = '<?xml version="1.0" encoding="UTF-8"?>....';
    binaryContent = charsetDecode(someTextContent, "utf-8");
    entry = createObject("java", "org.apache.commons.compress.archivers.tar.TarArchiveEntry").init("siteHeader.xml");
    entry.setSize(arrayLen(binaryContent));
    tar.putArchiveEntry(entry);
    tar.write(binaryContent);
    tar.closeArchiveEntry();

    // Create an entry from a file
    inputFile = createObject("java", "java.io.File").init("c:/path/someImage.jpg");
    entry = tar.createArchiveEntry(inputFile, "myImage.jpg");
    tar.putArchiveEntry(entry);
    tar.write(FileReadBinary(inputFile));
    tar.closeArchiveEntry();

    // Close TAR file
    tar.flush();
    tar.close();
</cfscript>