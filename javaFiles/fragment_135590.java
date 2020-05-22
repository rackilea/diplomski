List<Category> categories = new ArrayList<>();
while((line = br.readLine()) != null){
    String[] oneLineArray = line.split(seperate);
    Category c = new Category(oneLineArray[0]);
    categories.add(c);
}