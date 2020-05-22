public static void main(String[] args) throws Exception{

      BufferedReader br = new BufferedReader(new FileReader("Admin.txt"));
      ArrayList<Admin> al = new ArrayList<Admin>();
      String line = null;
      while ((line = br.readLine()) != null) {
        Admin admin = new Admin();
        String lines[] = line.split("|");
        /*adjust accordingly
        admin.setName(lines[0]);
        admin.setUser(lines[1]);
            ....*/
        al.add(admin);          
      }
      br.close();
}