public String getColorOfGuitar() {

    if(guitarColor.equals(Color.RED))
        return "RED";
    else if(guitarColor.equals(Color.BLUE))
        return "BLUE";
    else if(guitarColor.equals(Color.YELLOW))
        return "YELLOW";
    else
        return "Unknown Color";
}