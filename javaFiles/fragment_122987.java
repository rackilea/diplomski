BufferedReader in = new BufferedReader(  
                    new InputStreamReader(p.getInputStream()));  
String line = null;  
while ((line = in.readLine()) != null) {  
    System.out.println(line);  
}