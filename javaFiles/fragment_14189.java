java.lang.NoSuchMethodError: org.apache.commons.io.IOUtils.toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;
at org.apache.tika.parser.pkg.ZipContainerDetector.detectOpenDocument(ZipContainerDetector.java:192)
at org.apache.tika.parser.pkg.ZipContainerDetector.detectZipFormat(ZipContainerDetector.java:145)
at org.apache.tika.parser.pkg.ZipContainerDetector.detect(ZipContainerDetector.java:90)
at org.apache.tika.detect.CompositeDetector.detect(CompositeDetector.java:77)
at org.apache.tika.parser.AutoDetectParser.parse(AutoDetectParser.java:112)
...