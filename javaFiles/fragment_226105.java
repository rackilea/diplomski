StringBuffer buffer = new StringBuffer();

while (m.find()) {

    String tmp = m.group();
    char[] cTmp = tmp.toCharArray();

    for (int j = 0; j < cTmp.length; j++) {
        cTmp[j] = (char) (cTmp[j] + 1584);  // You don't need to typecast `cTmp[j]` to `int`.
    }

    m.appendReplacement(buffer, new String(cTmp));

}

m.appendTail(buffer);

System.out.println(buffer.toString());