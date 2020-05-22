StringBuilder sb = new StringBuilder();
String line = br.readLine();

while (line != null) {
    String s = br.readLine();

    parts = s.split("=");
    en=parts[0];
    sin=parts[1].split(" | ");

    sb.append("INSERT INTO `singlish`.`eng` (`eid`, `eword`) VALUES ('"+stpoint+"', '"+en+"');")
    sb.append(System.lineSeparator());

    System.out.println(en);

    for(int i=0;i<sin.length;i++) {
        sb.append("INSERT INTO `singlish`.`sng` (`eid`, `sword`) VALUES ('"+stpoint+"', '"+sin[i]+"');");
        sb.append(System.lineSeparator());
    }

    System.out.println(""+stpoint);
    stpoint++;
}