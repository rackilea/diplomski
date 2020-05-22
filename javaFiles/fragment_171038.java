String text = "[ABM-100]\n" +
              "0x00,Hours    \n" +
              "0x01,Minutes  \n" +
              "0x06,T2       \n" +
              "\n" +
              "[CO2SMO]\n" +
              "1   ,Instrument\n" +
              "2   ,Time               \n" +
              "3   ,AAI  \n";
Pattern p = Pattern.compile("^\\[(.*)\\]$", Pattern.MULTILINE);
Matcher m = p.matcher(text);
while (m.find())
    System.out.println(m.group(1));