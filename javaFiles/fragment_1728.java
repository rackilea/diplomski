addBtn.setOnClickListener(new View.OnClickListener() 
    { 
        @Override 
        public void onClick(View view) { 
            String newRestaurantName = newRestaurant.getText().toString(); 

            DatabaseReference newResturantRef = mRestReference.push();

            newResturantRef.child("name").setValue("Taco Bell");
            //also store the key of student, so that you can refer it later
            newResturantRef.child("studentKey").setValue(newResturantRef.getKey());
        } 
    });