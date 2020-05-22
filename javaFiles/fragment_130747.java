jsonString =[...];
Gson gson = new Gson();
PhotoDTO[] photos = gson.fromJson(jsonString, PhotoDTO[].class);

for(PhotoDTO photo : photos){
   System.out.println("photo -> " + photo.getPhoto());
}