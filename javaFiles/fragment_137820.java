public static String getAddress(List<Hus> list){
    if(list.isEmpty()){
        return "no address";
    } else {
        return list.get(0).getAddress();
    }
}