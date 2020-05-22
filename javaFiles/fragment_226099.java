private int age;

public void setDogAge(int age){ 
    if (age>0){
        this.age = age;
    } 
    else{
        System.out.println("Please Enter a Valid Age");
    }
}