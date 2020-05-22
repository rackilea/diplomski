@Override
public Parent add(Parent p){
    if (p instanceof A){
        A a = (A) p;
        return add(a);
    }
    else if (p instanceof B){
        B b = (B) p;
        return add(b);
    }
    else return null;
}