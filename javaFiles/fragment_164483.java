@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET, produces = "application/csv")
public void demo(HttpServletResponse response) throws IOException {
    List<String> names = new ArrayList<String>();
    names.add("First Name");
    names.add("Second Name");
    names.add("Third Name");
    names.add("Fourth Name");
    BufferedWriter writer = new BufferedWriter(response.getWriter());
    try {
        response.setHeader("Content-Disposition", "attachment; filename=\"test.csv\"");
        for (String name : names) {
            writer.write(name);
            writer.write(",");
        }
        writer.newLine();
    } catch (IOException ex) {
    } finally {
        writer.flush();
        writer.close();
    }
}