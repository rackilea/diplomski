ArrayList<ArrayList<String>> m_arrAllStats= new ArrayList<ArrayList<String>>();
PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
pw.println("");
m_arrAllStats
    .stream()
    .filter(m -> (m.size() > 0))
    .forEach(s -> pw.print(String.join(",", s)));

pw.println("");
pw.close();