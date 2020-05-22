public class experiment {

public String baseDir;

    for (int exp = 0; exp < experimentCnt; exp++) {
        String dirString = config.getClass().getSimpleName() + "_" + df.format(new Date());
        baseDir = new File(homeDir + "/" + dirString).getAbsolutePath();
        System.out.println("Running simulation: " + dirString);

        setCurrentDirectory(baseDir);

        PrintWriter paramsLog = null;

        try {
            paramsLog = new PrintWriter(
                 new File("experimentParams.log").getAbsoluteFile(), "UTF-8");
            paramsLog.println(params);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }