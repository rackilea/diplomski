System.out.print("Enter a subdomain: ");
Scanner sc = new Scanner(System.in);
String subdomain = sc.next();
URI url = new URI("http://" + subdomain + ".domain.com");
Desktop d = Desktop.getDesktop();
d.browse(url);