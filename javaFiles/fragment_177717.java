public static Student getInstance(String type) {
    if (type.equals("graduate")) 
        return new Graduate();
    else if (type.equals("phd"))
        return new Phd();
}