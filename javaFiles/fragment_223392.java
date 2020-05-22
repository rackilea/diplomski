@RequestMapping(value = "/all", method = RequestMethod.GET)
@ResponseBody
public String getAll() throws Exception {
    List<String> list = labService.getAll();

    // build fake little json formatted data
    StringBuffer sb = new StringBuffer("{");
    for (String s : list) {
        sb.append("{ "+s+" }, ");
    }
    sb.append("}");

    return sb.toString();
}