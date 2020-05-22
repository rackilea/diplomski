List<String> listS = new ArrayList();
List<Integer> listI = new ArrayList();
// try with resource automatically close resources
try (BufferedReader reader = Files.newBufferedReader(Paths.get("res.txt"))) 
{
    reader.lines().forEach(line -> {
        String[] ints = line.split(" ");
        listS.add(String.valueOf(ints[0]));
        listI.add(Integer.parseInt(ints[1]));
        listI.add(Integer.parseInt(ints[2]));
    });

} catch (IOException e) {
    e.printStackTrace();
}