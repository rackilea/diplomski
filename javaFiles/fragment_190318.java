private Person person;
private Address address;     

public void beanProcessed(Class<?> beanType, Object beanInstance, C context){
    if(beanType == Person.class){
         person = (Person) beanInstance;
    }
    if(beanType == Address.class){
         address = (Address) beanInstance;
    }
    if(person != null && address != null){
         //got all beans from a row, process them
         process(person, address);

         //clear up until you get the instances produced for the next record.
         person = null;
         address = null;
    }
}