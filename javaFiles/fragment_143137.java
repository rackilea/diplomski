// Use encoding of your choice
    Writer out = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(fileDir), "UTF8"));

    // append and flush in logical chunks
    out.append(toSend).append("\n");
    out.append("appending more before flushing").append("\n");
    out.flush();