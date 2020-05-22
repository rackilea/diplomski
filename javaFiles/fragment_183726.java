FromXmlToJava ( InputStream inputStream)
    {

     this.inputStream = inputStream;

    }

 private BufferedReader getBufferedReader(InputStream is) 
    {
      return new BufferedReader(new InputStreamReader(is));
    }

public void run() {

    BufferedReader br = getBufferedReader(inputStream);
    String ligne = "";
    try 
    {
        while ( (ligne = br.readLine() )!= null)
        {


            System.out.println(ligne);
        }


    } catch (IOException e) 

        {

            e.printStackTrace();
        }


}

public static class Main {
    // chemin de l'emplacement des classes generées 

    public static final String CHEMIN = "C:\\Users\\****";
     public static void main(String[] args) {
            try {
                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C",
                        "C:\\Users\\***\\xjc.bat ***.xsd");

                // modifier le repertoire d'execution de la commande 

                pb.directory(new File(CHEMIN));



               /* Map env = pb.environment();
                for (Entry entry : env.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }

                env.put("MonArg", "Valeur");
                */
                Process p = pb.start();
                FromXmlToJava fluxSortie = new FromXmlToJava(p.getInputStream());
                FromXmlToJava fluxErreur = new FromXmlToJava(p.getErrorStream());
                new Thread(fluxSortie).start();
                new Thread(fluxErreur).start();
                p.waitFor();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
}
}