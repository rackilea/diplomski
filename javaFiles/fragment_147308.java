@Override
public boolean equals(Object obj){
    if(obj == this){
        return true;
    }
    if(obj instanceof Circle){
        Circle circle = (Circle) obj;
        if(circle.getWidth()==getWidth())
            return true;
    }
    return false;
}