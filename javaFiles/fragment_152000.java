String[] result = File.nextLine().split(",");
for (int x = 0; x < result.length; x++){
    if (result[x].isEmpty()) {
    System.out.println("Undefined");
    } else
    System.out.println(result[x]);
}