private static String UUID = "([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})";

private static String url = "customers/00000000-0000-0000-0000-000000000111/areas/00000000-0000-0000-0000-000000000222/orders/00000000-0000-0000-0000-000000000555/invoices/00000000-0000-0000-0000-000000000777/employees/2018-10-31T00:27:31.205+0000.jpg";

private static String EXTENSION = ".+(?:mov|jpg)";

public static void main(String[] args) {
    Pattern JPG_PATTERN = Pattern.compile(String.format("customers/%s/areas/%<s/orders/%<s/invoices/%<s/employees/%s", UUID, EXTENSION));

    Matcher m = JPG_PATTERN.matcher(url);

    if (m.matches()) {
        System.out.println("found");
    } else {
        System.out.println("not found");
    }

}