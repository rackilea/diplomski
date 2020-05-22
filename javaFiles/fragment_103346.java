@RequestMapping(value="/hadoop" , method = RequestMethod.GET)
public String hadoop(ModelMap model) throws URISyntaxException, IOException {
    String result = null;

    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get( new URI("hdfs://myhost:9000"), conf);

    Path file = new Path("/user/michael/input/input1.txt");
    FSDataInputStream getIt = fs.open(file);
    BufferedReader d = new BufferedReader(new InputStreamReader(getIt));

    String s = "";
    while ((s = d.readLine()) != null) {
        result += s;
    }
    d.close();
    fs.close();

    model.addAttribute("result", result);
    return "hello";
}