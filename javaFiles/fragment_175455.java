private static final String NIFSOURCE = "A:PE9301_P# show port 1/1/1\r\n"+
        "===============================================================================\r\n"+
        "Ethernet Interface\r\n"+
        "===============================================================================\r\n"+
        "Description        : PE9301_P:PE9148_P:01:10G\r\n"+
        "Interface          : 1/1/1                      Oper Speed       : 10 Gbps\r\n"+
        "Link-level         : Ethernet                   Config Speed     : N/A\r\n"+
        "Admin State        : up                         Oper Duplex      : full\r\n"+
        "Oper State         : up - Active in LAG 1       Config Duplex    : N/A\r\n"+
        "Physical Link      : Yes                        MTU              : 9212\r\n"+
        "Single Fiber Mode  : No                         Min Frame Length : 64 Bytes";

/**
 * Ceci est un test que l'ont peut remplacer par une méthode Main ou une function 
 *                                                             - Uncle Bob Martin
 */
@Test
public void NIFParseTest() {
    String NIFdescription = null, NIFstate = null;

    Pattern motifRE = Pattern.compile("^Description\\s+:\\s(\\w+)", Pattern.MULTILINE);
    Pattern stateRE = Pattern.compile("^Oper State\\s+:\\s(.{26,26})", Pattern.MULTILINE | Pattern.UNIX_LINES);

    Matcher foundMatch = motifRE.matcher(NIFSOURCE);
    if (foundMatch.find()) {
        NIFdescription = foundMatch.group(1); //0 est la chaine complète, les motifs entre parenthèse sont disponibles à l'index 1
    }

    foundMatch = stateRE.matcher(NIFSOURCE);
    if (foundMatch.find()) {
        NIFstate = foundMatch.group(1);
    }
    assertNotNull(NIFdescription);
    assertNotNull(NIFstate);
}