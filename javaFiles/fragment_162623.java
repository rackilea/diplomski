library(rJava)
.jinit()
.jaddClassPath("poi-3.10-beta3-20131022.jar")
.jaddClassPath("poi-scratchpad-3.10-beta3-20131022.jar")

inputStream <- .jnew("java/io/FileInputStream", path.expand("test.doc"))
wdoc <- .jnew("org/apache/poi/hwpf/HWPFDocument", 
              .jcast(inputStream,"java/io/InputStream"))
wext <- .jnew("org/apache/poi/hwpf/extractor/WordExtractor", wdoc)

text <- .jcall(wext, "Ljava/lang/String;", "getText")
print(text)