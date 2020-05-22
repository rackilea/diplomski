public String toString() {
    String result = name;
    result += " | ";
    result += getSpecies();
    result += " | ";
    result += strength;
    result += " | ";
    result += hitPoints;
    result += "\n";
    return result;