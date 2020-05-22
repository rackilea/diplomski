public class LogParse {
    public static void main(String[] args) throws GrokException, IOException {


        // Get an instance of grok
        Grok grok = new Grok();

        // add a pattern to grok
        grok.addPattern("LOGLEVEL", "\\w+");
        grok.addPattern("YEAR", "\\w+");
        grok.addPattern("MONTHNUM", "((?:0?[1-9]|1[0-2]))");
        grok.addPattern("MONTHDAY", "(?:[+-]?(?:[0-9]+))");
        grok.addPattern("HOUR", "(?:[+-]?(?:[0-9]+))");
        grok.addPattern("MINUTE", "(?:[+-]?(?:[0-9]+))");
        grok.addPattern("SECOND", "(?:(?:[0-5][0-9]|60)(?:[:.,][0-9]+)?)");
        grok.addPattern("GREEDYDATA", ".*");


        grok.compile("%{LOGLEVEL:loglevel} %{YEAR:year}-%{MONTHNUM:month}-%{MONTHDAY:day} %{HOUR:hour}:%{MINUTE:minute}:%{SECOND:second} (%{GREEDYDATA:data}) - %{GREEDYDATA:message} %{GREEDYDATA:Erreur}");
        grok.compile("%{LOGLEVEL:loglevel} %{YEAR:year}-%{MONTHNUM:month}-%{MONTHDAY:day} %{HOUR:hour}:%{MINUTE:minute}:%{SECOND:second} (%{GREEDYDATA:data}) - %{GREEDYDATA:message}");


        try{

               FileInputStream fstream = new FileInputStream("C://file.log");
               BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
               String log;
                //output
                BufferedWriter output = new BufferedWriter(new FileWriter("out.json"));

               /* read log line by line */
               while ((log = br.readLine()) != null)   {

                 System.out.println (log);
                 Match gm = grok.match(log);
                    gm.captures();

                    //output
                    System.out.println(gm.toJson());
                    output.write(gm.toJson());
                    output.newLine();

               }
               output.close();
               fstream.close();

            } catch (Exception e) {
                 System.err.println("Error: " + e.getMessage());
            }   }}