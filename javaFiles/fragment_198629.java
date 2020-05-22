public Map<String, Integer> getResultAsMap(ResultSet rs) {
    Map<String, Integer> myMap = new HashMap<String, Integer>();

    for (; rs.hasNext();) {
        QuerySolution soln = rs.nextSolution();

        String stream = soln.get("stream").toString();
        String noOfStudentsStr = soln.get("numberOfStudents").toString();
        int noOfStudents = Integer.parseInt(noOfStudentsStr);
        myMap.put(stream, noOfStudents);
    }

    return myMap;
}