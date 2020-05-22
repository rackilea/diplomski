public String getImg(String d){
    return rubahFormat(d).split(",");
}

public String rubahFormat(String d){
    return d.replaceAll("[\\[\\]\\\"]","");
}