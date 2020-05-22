private static void indirectAccess(Scanner in){
    System.out.print("URL: ");
    String url = in.nextLine();
    Teste finalUrl = client.generateIndirectAccess(url);
    byte[] response = rest.getForObject(indirect, byte[].class, finalUrl.getId(), finalUrl.getUrl(), Base64.encodeBase64URLSafeString(finalUrl.getSig()));
    System.out.println(new String(response));
}