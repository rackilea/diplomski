public class TestClass {
    public static void main(String[] args) throws Exception {

        KeyStore p12 = KeyStore.getInstance("pkcs12");
        p12.load(new FileInputStream("pkcs.p12"), "password".toCharArray());
        Enumeration<String> e = p12.aliases();
        while (e.hasMoreElements()) {
            String alias = e.nextElement();
            X509Certificate c = (X509Certificate) p12.getCertificate(alias);
            Principal subject = c.getSubjectDN();
            String subjectArray[] = subject.toString().split(",");
            for (String s : subjectArray) {
                String[] str = s.trim().split("=");
                String key = str[0];
                String value = str[1];
                System.out.println(key + " - " + value);
            }
        }
    }
}