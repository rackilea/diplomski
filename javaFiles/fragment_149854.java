@Override
public void configure() throws Exception {
    from("file:/tmp/test?include=.*.csv")
       .setProperty("outputFile", simple("${header.CamelFileName}.${exchangeId}.pgp"))
       .log("The body will be PGP encoded & written to file ${property.outputFile}")
       .marshal().pgp("keyFileName", "keyUserid")
       .to("file:/tmp/test/output?fileName=${property.outputFile}");
    }
}