// headers
    writer.write("TerminalSerialNo,IMEI,Site-Ref,Site-Name\n");
    writer.flush();

    // data
    for(String[] arr: list) {
        String appender = "";
        for(String s : arr){
            writer.write(appender + s);
            appender = ",";

        }
        writer.write("\n");
        writer.flush();
    }
    writer.close();


    `