public void showAllFilms(){
    ArrayList<String[]> films = getFilms();
    for(String[] film : films){
        System.out.println("id "+film[0]+"\ntitle "+film[1]);
    }
 }

 public existsFilm(String filmName){
     ArrayList<String[]> films = getFilms();
     for(String[] film : films){
         if(film[1].equals(filmName)){
           return true;
         }
     }
     return false;
 }

 public ArrayList<String[]> getFilms(){
    ArrayList<String[]> filmList = new ArrayList();
    int lineRead = 0;
    try{
        File file = new File("yourfile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)));
        String line;
        while ((line = br.readLine()) != null) {
           String[] data = line.split(":");
           if(data.length > 0){
               filmList.add(new String[]{data[1],data[3],data[5],data[7]});
           }
           lineRead++;
        }
    }catch(Exception ex){
        System.out.println("Error reading line "+lineRead);
        ex.printStackTrace(); //very ugly using this (common is logging it)
    }
    return filmList;
 }