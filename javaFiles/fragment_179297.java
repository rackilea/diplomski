void initLists(Model model) {
    LinkedHashMap<Integer, String> gradeList = new LinkedHashMap<Integer, String>();
    gradeList.put(1, "Class 1");
    gradeList.put(2, "Class 2");
    gradeList.put(3, "Class 3");
    gradeList.put(4, "Class 4");
    gradeList.put(5, "Class 5");
    model.addAttribute("gradeList", gradeList);

    List<String> genderList = new ArrayList<String>();
    genderList.add("Male");
    genderList.add("Female");
    model.addAttribute("genderList", genderList);

    List<String> extraSubjects = new ArrayList<String>();
    extraSubjects.add("Math II");
    extraSubjects.add("Population");
    extraSubjects.add("Computer");
    model.addAttribute("extraSubjects", extraSubjects);
}