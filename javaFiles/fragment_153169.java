public static void main(String[] args) {
    Provider[] provs = Security.getProviders();
    for (Provider provider : provs) {
        Service service = provider.getService("Cipher", "AES");
        if (service == null) {
            continue;
        }

        String modes = service.getAttribute("SupportedModes");
        if (modes != null && modes.matches("(?i).*CTR.*")) {
            System.out.println(service);
        }
    }
}