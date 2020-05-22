class Device implements Comparable<Device> {

    private String device;
    private String number;

    @Override
    public int compareTo(Device o) {
        return o.number.compareTo(this.number);
    }
}