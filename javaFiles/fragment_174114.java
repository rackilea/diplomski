protected void onCreate(Bundle savedInstanceState) {
        ...........
        ...........

         // you should  instantiate 'DatabaseHandler'  here
        DatabaseHandler db = new DatabaseHandler(this); // "this" refer to the context

        ..........
        ..........

 // insert the rows
 db.createCar(new Car("Sesame street A","23423","anImage1"));
 db.createCar(new Car("Sesame street B","43543","anImage2"));

 // get the rows which you mean string
 for(Car cars : db.getCurrentCar()){
 String rows= "id : "+ cars.getID()+ " address : "+getAddress() + "postcode : "+getPostcode()+" image : "+getImage());
 }  
}