private MultiPartSpecification getMultiPart() {
         return new MultiPartSpecBuilder("Test-Content-In-File".getBytes()).
                fileName("book.txt").
                controlName("file").
                mimeType("text/plain").
                build();
   }