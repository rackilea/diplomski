public enum DataType {

PROFILE("Profile"),
SUPPORT_DETAIL("SupportDetail");

private String value;
private DataType(String value) {
    this.value = value;
}

@Override
public String toString() {
    return this.value;
}
}