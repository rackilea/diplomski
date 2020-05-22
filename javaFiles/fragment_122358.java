public static List<String> allDisciplines(ArrayList<Subject> inputSubjects){


    //initialise new arraylist
    List<String> dis = new ArrayList<>();

    for (Subject subject : inputSubjects) {
        dis.add(subject.getDiscipline());
    }
    return dis;
}