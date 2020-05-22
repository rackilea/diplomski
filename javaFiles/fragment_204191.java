String str = "CN666SEEEI\n" +
    "FOC000007HW (2190000002)\n" +
    "FHK10AAAAAA (2850000004)\n" +
    "JAB031444BA (3108888022)\n" +
    "S/N JAE14445WW7\n" +
    "Serial :FOC0818S08R Model : Cisc\n" +
    "Serial_Number: FHK10HHHQ4\n" +
    "Model:CISCO7200VXR, SN:36555555\n" +
    "Cisco CISCO3845 SN: FGL15555532\n" +
    "CISCO2831 FHK13XXXX1E\n" +
    "CISCO1851 SN: FHK1XXXX55M\n" +
    "CISCO2821 SN: FHK1333F11J\n" +
    "CISCO2921/K9, SN: FHK1444FF7F\n" +
    "Cisco 1941/k9 Sn: FHK13HHHTQ\n" +
    "CISCO2121 SN: FHKFFFFFFEY\n" +
    "WS-C2970-24TC-L, SN: FOCXXXXZ34K\n" +
    "WS-C3760-24TS-S, SN: FDOXXXXX0F6\n" +
    "38 42 42 42 42 42 42 44 42 42";

Matcher m = Pattern.compile( "\\b(?!CISCO)[A-Z\\d]{8,}(?=\\s|$)" ).matcher( str ); 

while ( m.find() ) {
    System.out.println( m.group() );
}