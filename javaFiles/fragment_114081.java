static List<Triangle> parse(String fileName) 
{
  List<Triangle> mesh = new ArrayList<>();  
  Map<String, Vector> vm = new HashMap<>();

  try (Scanner scan = new Scanner(new FileReader(fileName)))
  {
    while(scan.hasNextLine()) 
    {
      String[] p = scan.nextLine().split("\\s");
      if("v".equals(p[1]))
      {
        vm.put(p[0], new Vector(Double.parseDouble(p[2]), Double.parseDouble(p[3]), Double.parseDouble(p[4])));
      }
      else if("f".equals(p[1]))
      {
        mesh.add(new Triangle(vm.get(p[2]), vm.get(p[3]), vm.get(p[4])));
      }
    }
  }
  catch(IOException e)
  {
    e.printStackTrace();
  }
  return mesh;
}