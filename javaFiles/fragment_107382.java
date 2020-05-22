Process pDb = Runtime.getRuntime().exec("cmd /c restore_db.bat",null, new File(projectPath));

InputStream stderr = pDb.getErrorStream();
InputStreamReader isr = new InputStreamReader(stderr);

try (final BufferedReader b = new BufferedReader(isr)) {
            String line;

            while ((line = b.readLine()) != null) {
                  System.out.println(line);
            }
}

log.info("waiting for restore complete database...");

exitVal = pDb.waitFor();

log.info("Process exitValue: " + exitVal);