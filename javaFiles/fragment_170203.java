private class SRD {
    List<String> destination_addresses;
    List<String> origin_addresses;
    List<Row> rows;

}

private class Row{
    List<Element> elements;

}


private class Element {
    General duration;
    General distance;
    String status; 

}

private class General {
    String text;
    int value;


    public String toString() {
        return "duration{" + "text=" + text + ", value=" + value + '}';
    }


}