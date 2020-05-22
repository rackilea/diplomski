String cuatro = ("#TodosPorKiKi El plan de flia solidaria No Puede exceder los 6meses. https//t/MUY0bj2qMT" +
            " La justicia de Santa Fe lo abandonó 2 años y ahora\r\n" +
            "Quieren hacerse los legalistas\r\n  https//t/MUY0bj2qMT" +
            "#Verguenza  Respete los derechos del niño @MiguelLifschitz @DataLifschitz https//t/MUY0bj2qMT");
String cleaned = cuatro.replaceAll("http\\S*", ""); 
System.out.println(cleaned);    // I added multiple url in the String, for you can see it remvoes all