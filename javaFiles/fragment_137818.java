public String address(){
    for (Hus h : houses){
        return h.getAddress();
    }
    return null;
}