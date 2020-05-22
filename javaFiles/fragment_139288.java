try {
     Scanner sc = new Scanner(new File("fugler.txt"));
     List<String> lines = new ArrayList<String>();
     while (sc.hasNextLine()) {
         lines.add(sc.nextLine());
     }

     for (String line : lines) {
         if(line.contains("yourSearchString")) {
             System.out.println(line);
         }
     }

 } catch (Exception e) {
 }