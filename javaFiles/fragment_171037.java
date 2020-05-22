String[] lines = { "[ABM-100]",
                   "0x00,Hours    ",
                   "0x01,Minutes  ",
                   "0x06,T2       ",
                   "",
                   "[CO2SMO]",
                   "1   ,Instrument",
                   "2   ,Time               ",
                   "3   ,AAI  " };
Pattern p = Pattern.compile("\\[(.*)\\]");
for (String line : lines) {
    Matcher m = p.matcher(line);
    if (m.matches())
        System.out.println(m.group(1));
}