public String getSize()
{
    if (weight < 30) {
       return "small";
    } else {
        if (weight >= 30 && weight <=60) {
            return "medium";
        } else {
            return "large";
        }
    }
}