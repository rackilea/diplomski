private static int tagCount(XMLTree xml, String tag) {
    assert xml != null : "Violation of: xml is not null";
    assert tag != null : "Violation of: tag is not null";

    int count = 0;

    if (xml.isTag()) {
        for (int i = 0; i < xml.numberOfChildren(); i++) {
            if (xml.child(i).label().equals(tag)) {
                count++;
            }
            count = count + tagCount(xml.child(i), tag);
        }
    }
    return count;
}