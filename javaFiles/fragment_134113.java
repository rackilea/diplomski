String[] planets = {"Mars", "Earth", "Jupiter"};        
String format = "\r%s says Hello";

for(String planet : planets) {
    System.out.printf(format, planet);
try { 
        Thread.sleep(1000); 
    }catch(Exception e) { 
        //... oh dear
    }
}