Process p = Runtime.getRuntime().exec("ls");
p.waitFor();
Scanner s = new Scanner(p.getInputStream());
while (s.hasNextLine()) {
    String l = s.nextLine();
    System.out.println(l);
}