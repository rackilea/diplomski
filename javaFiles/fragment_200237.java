for(String s1 : collection1){
    for(String s2 : collection2){
        if (s1.hashCode() == s2.hashCode() && s1.equals(s2)) {
            System.out.println("matched");
        }
    }
}