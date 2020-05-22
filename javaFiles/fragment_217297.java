public ModelDoa(String name, String butong, int type) {
    this.mName = name;
    this.bName = butong;
    this.mType = type;
    String[] data = butong.split("\\s");
    if (data.length > 0) {
        String count = data[1].substring(0, data[1].length() - 1);
        read10 = Integer.parseInt(count);
    }
}