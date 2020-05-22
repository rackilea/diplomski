class Person{
    String name;

    public void setName(String name){
        this.name = name;
    }

    class Displayer {
        String getPersonName() { 
            return Person.this.name; 
        }

    }
}