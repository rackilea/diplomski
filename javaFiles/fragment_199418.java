int atIndex = email.indexOf('@');
int dotIndex = email.indexOf('.');
if (atIndex > 2 && dotIndex > atIndex + 2) {
  String masked = email.charAt(0)
    + email.substring(1, atIndex - 1).replaceAll(".", "*")
    + email.substring(atIndex - 1, atIndex + 2)
    + email.substring(atIndex + 2, dotIndex - 1).replaceAll(".", "*")
    + email.substring(dotIndex - 1);
  System.out.println(masked);
}