public String getStatus(int age){
    this.age = age;
    if (age < 30 && isStudying == true && isEmployed == false){
        return name + " is a student";
    }    else if((age > 30 || age < 65) && isStudying == false && isEmployed == true){
        return name + " is an employee";
    }    else if(age > 65 && isStudying == false && isEmployed == false){
        return name + " is retired";
    }
    return null;
}