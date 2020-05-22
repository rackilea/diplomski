public void Reproduce() {
   Constructor c = tc.getClass().getDeclaredConstructor(String.calss, Integer.class); //pass types of parameters as in consrtuctor you want to use. In 
            //this case I assume that Cat class has constructor with first parameter of type String and second parameter of type Integer
   Cat cat = (Cat)c.newInstance("someString", 2); 
   // change some properties of object c if needed
   addAnimal(cat);
}