Files.write(Paths.get("D://Author.html"), 
            String.join("" /* or new line? */, 
                        doc.getElementsByClass("a_code")
                           .eachText()
                       ).getBytes(), 
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);