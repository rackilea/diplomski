public List<String> getAddresses(List<Hus> list){
    List<String> addresses = new ArrayList<>();
    for(Hus h: list){
        addresses.add(h.getAddress());
    }
    return addresses;
}