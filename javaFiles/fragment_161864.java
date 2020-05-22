try {
    oProcess = oRuntime.exec(aCmdArgs);
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(
            oProcess.getOutputStream()));
    writer.println(200);
    writer.close();
    oProcess.waitFor();
} catch (Exception e) {
    System.out.println("error executing " + aCmdArgs[0]);
}