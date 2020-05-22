public Group(String line) {
    String[] items = line.split(":");
    this.name = items[0];
    this.gid = Integer.parseInt(items[2]);
    if (items.length > 3){
        this.members = items[3];
    }
}