public String toStars(int number) {
    StringBuilder temp = new StringBuilder();
    for(int i=0;i<number;i++) {
        temp.append("*");
    }
    return temp.toString();
}