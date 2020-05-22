@Override
public boolean equals(Object obj) {
    if(obj instanceof Actor){
        Actor a = (Actor)obj;
        if(this.name.equals(a.name)){
            return true;
        }
    }
    return false;

}