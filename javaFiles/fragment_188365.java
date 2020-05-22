class Module {
    private static HashMap<Integer, Integer> courseCounts = new HashMap<Integer, Integer>();

    public Module(int semester, String name) {
        this.semester = semester;
        this.name = name;
        Integer count = courseCounts.get(semester);
        if (count == null)
            count = 0;
        ++count;
        this.code = "M" + (semester * 100 + count);
        courseCounts.put(semester, count);
    }
}