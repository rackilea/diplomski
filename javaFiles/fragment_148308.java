class ContainerClass{
     int id;
     String company;

     //helper method to get all the objects needed
     static ContainerClass[] getAll(){
          ContainerClass test = new ContainerClass();
          test.id = 2;
          test.company = "abc";
          return new ContainerClass[]{test,test,test};
     }

     @Override
     //this String is what actually will be displayed in the combobox
     public String toString(){return "(" + id + ") " + company;}
}