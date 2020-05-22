class details {
String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

int age;
int id;

public details() {
}

public details(String name_, int age_, int id_) {
    name = name_;
    age = age_;
    id = id_;
}