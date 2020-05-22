BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader(new File("Assets/Setup/Buildings.txt")));
    // do things
} catch (Exception e){
   //Handle exception
} finally {
    try {
        br.close();
    } catch (Exception e){}
}