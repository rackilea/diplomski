int totalOffset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);

    StringBuilder sb = new StringBuilder();

    //handle zero offset
    if (totalOffset == 0) {
        sb.append('Z');
    }

    //convert to minutes because timezones are minute based
    totalOffset = totalOffset / 60000;
    char prefix = '-';
    if (totalOffset >= 0) {
        prefix = '+';
    }
    sb.append(prefix);

    //if negative offset, invert now
    totalOffset = Math.abs(totalOffset);

    sb.append(String.format("%02d", (totalOffset / 60)));
    sb.append(':');
    sb.append(String.format("%02d", (totalOffset % 60)));

    System.out.println(sb.toString());