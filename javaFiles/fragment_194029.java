log.info("File Splitter :: Start");

    List<String> pl = (List<String>) exchange.getIn().getBody(List.class);
    log.info("File Pay Load: " + pl);

    fName = pl.get(0);  //get file name
    exchange.getIn().setHeader("CamelFileName", fName);
    pl.remove(0);
    log.debug("**** serviceRecords  ****");
    Iterator<String> pitr = pl.iterator(); 
    while ( pitr.hasNext()) {
          log.debug(pitr.next());
      }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(baos);
    for (String record : pl) {
        out.writeBytes(record + System.lineSeparator());
    }
    out.flush();
    exchange.getIn().setBody(baos.toByteArray());
    out.close();

    log.info("File Splitter :: Finish");