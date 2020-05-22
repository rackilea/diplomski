public static void main(String[] args){
    String fichier ="E:\\fichiers\\test.txt";

    int tab[] = {2, 2, 20, 8, 20, 8, 4, 3, 7, 3, 3, 3, 18, 139};
    String tabS[] = new String[14];

    try {

        InputStream       ips  = new FileInputStream(fichier); 
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader    br   = new BufferedReader(ipsr);

        for(int i=0; i<tab.length; i++){

            char cbuf[] = new char[tab[i]];

            br.read(cbuf, 0, tab[i]);

            tabS[i] = new String(cbuf);
            System.out.println(tabS[i]);
        }

    } catch (Exception e){
        System.out.println(e.toString());
    }
}