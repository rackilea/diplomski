class Main {
    public static void main(String[] args) {
        String xml="<soap:Envelope\n" + 
                "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + 
                "    <soap:Body>\n" + 
                "        <soap:Fault>\n" + 
                "            <faultcode>soap:Server</faultcode>\n" + 
                "            <faultstring>A PLP não será fechada, o(s) objeto(s) [PX44258394BR, PX44258388BR, PX44258382BR] já estão vinculados em outra PLP!</faultstring>\n" + 
                "            <detail>\n" + 
                "                <ns2:SigepClienteException\n" + 
                "                    xmlns:ns2=\"http://cliente.bean.master.sigep.bsb.correios.com.br/\">A PLP não será fechada, o(s) objeto(s) [PX44258394BR, PX44258388BR, PX44258382BR] já estão vinculados em outra PLP!\n" + 
                "                </ns2:SigepClienteException>\n" + 
                "            </detail>\n" + 
                "        </soap:Fault>\n" + 
                "    </soap:Body>\n" + 
                "</soap:Envelope>";
        String searchStr="A PLP não será fechada";
        System.out.println(xml.contains(searchStr));
    }
}