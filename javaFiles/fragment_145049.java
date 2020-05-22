private String getIPSender(Document doc) {
    String ip = "";
    if (doc != null) {
        try {
            while (doc.hasItem("Received")) {
                Item item = doc.getFirstItem("Received");
                if (item.getValueString().contains("[")) {
                    ip = item.getValueString();
                }
                item.remove();
            }
            if (!ip.isEmpty()) {
                ip = ip.substring(ip.indexOf("[") + 1);
                ip = ip.substring(0, ip.indexOf("]"));
            }
        } catch (Exception e) {
            ip = "";
        }
    }
    return ip;
}