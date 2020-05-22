//This is the copy constructor
Teacher(Teacher t){
        setName(t.getName());
 }

//That's how you clone an object of type teacher
protected Teacher clone(){
   return new Teacher(this);
}