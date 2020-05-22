URL url = new URL("https://www.cardservices.uga.edu/fs_mobile/index.php/dashboard/occupancies/"); //This is the AJAX call that goes to load the data into webpage. You can get this from inspecting the network calls.
    URLConnection con = url.openConnection();
    InputStream is = con.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = br.readLine()) != null){
        System.out.println(line); 
    }