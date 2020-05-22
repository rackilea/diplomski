String formula = "=IF(BI18=0;INT(YEAR(TODAY()));IF(INT(YEAR(BI18))>2025;2025;INT(YEAR(BI18))))";
//                            | positive lookbehind: starts with "IF("
//                            |        | any character, reluctantly quantified
//                            |        |  | positive lookahead, followed by 
//                            |        |  | ")", then...
//                            |        |  |     | ";" or end of input
//                            |        |  |     | 
Pattern p = Pattern.compile("(?<=IF\\().+?(?=\\)(;|$))");
Matcher m = p.matcher(formula);
while (m.find()) {
    System.out.println(m.group());
}