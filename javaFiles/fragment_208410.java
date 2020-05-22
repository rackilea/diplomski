public void addPhoto(String s){

   somePictures.add(new Bild(s));
   p.add(somePictures.get(somePictures.size()-1));

   getContentPane().revalidate();
   getContentPane().repaint();
}

// Simplify your code. Reuse
public void addPhoto(String [] arr){
   for(String s : arr){
        addPhoto(s);
   }
}