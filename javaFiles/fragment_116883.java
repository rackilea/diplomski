String result = "...";
for (String line : result.split("\n")) {
     System.out.println("-> " + line);
     for (String column : line.split("\\s{2,}")) {
         System.out.println("  => [" + column.trim() + "]");
     }
 }