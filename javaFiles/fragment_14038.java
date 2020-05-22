@Override
public boolean equals(Object o){
    //-- add it to your code --//
    if(o == this) 
        return true;

    if(!(o instanceof Student)) 
        return false;

    //-- at this point you're safe to cast --//

    Student student = (Student) o;
    boolean flag = false;
    if(this.getId() == student.getId()){
        flag = true;
    }
    return flag;
}