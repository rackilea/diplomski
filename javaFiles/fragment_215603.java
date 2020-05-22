public int hashCode() {
    int result = 17;
    int prime = 31;

    int lowest = first < second ? first : second;
    int highest = first < second ? second : first;

    result = result * prime + lowest;
    result = result * prime + highest;
    return result;
}