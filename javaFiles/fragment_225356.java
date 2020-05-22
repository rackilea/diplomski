@Override
public boolean equals(Object obj) {
    if(obj==null){
        return false;
    }

    if(obj instanceof Stagione){
        return ((Stagione)obj).getId().equals(getId());
    }else if (obj instanceof String){
        return descrizione.equals(obj);
    }else {
        // Or return false...
        return super.equals(obj);
    }
}