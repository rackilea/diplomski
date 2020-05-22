private String[] decodeLogonHours(Attribute attr)
{
    byte[] raw = attr.getValueByteArray();
    String[] days = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    ArrayList<String> ret = new ArrayList<String>();

    for (int day = 0 ; day < days.length ; day++) {
        byte[] vBits;
        if (day == 6) {
            vBits = new byte[] { raw[19], raw[20], raw[0] };
        } else {
            vBits = new byte[] { raw[day*3+1], raw[day*3+2], raw[day*3+3] };
        }

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%s:", days[day]));
        for (int b = 0 ; b < 3 ; b++) {
            sb.append(" ");
            sb.append(decodeLogonBits(vBits[b]));
        }
        ret.add(sb.toString());
    }

    String[] r = new String[ret.size()];
    ret.toArray(r);
    return r;
}

private String decodeLogonBits(byte b) {
    StringBuffer sb = new StringBuffer();
    sb.append((b & 0x01) > 0 ? "1" : "0");
    sb.append((b & 0x02) > 0 ? "1" : "0");
    sb.append((b & 0x04) > 0 ? "1" : "0");
    sb.append((b & 0x08) > 0 ? "1" : "0");
    sb.append((b & 0x10) > 0 ? "1" : "0");
    sb.append((b & 0x20) > 0 ? "1" : "0");
    sb.append((b & 0x40) > 0 ? "1" : "0");
    sb.append((b & 0x80) > 0 ? "1" : "0");
    return sb.toString();
}