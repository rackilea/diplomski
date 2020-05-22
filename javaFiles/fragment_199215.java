String fact = "def getBookInformation(n) {" +
                "  xmlDesc = new XmlSlurper().parse(n)\n" +
                "  xmlDesc.book.findAll().collectEntries {\n"+
                "    [ (it.@id):[ it.name, it.author ] ]\n" +
                "  }\n" +
                "}" ;