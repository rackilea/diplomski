public void set(String mode, String status) {
    this.map.put(mode, status);
}

public String getStatus(String mode) {
    return this.map.get(mode);
}