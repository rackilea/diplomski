// Result: Max mark for each subject
    Map<Long, Marks> maxPerSubject = new HashMap<>();
    // Input (SubList in a List? One sublist per alumn?
    List<List<Marks>> listOfSubLists = new ArrayList<List<Marks>>();

    for (List<Marks> subList : listOfSubLists) {
        for (Marks currentMark : subList) {
            long subjectCode = currentMark.subjectCode;
            Marks currentMax = maxPerSubject.get(subjectCode);
            // If it is the first mark for the subject, or greater
            // If marks are equal, then first will be kept
            if (currentMax == null || currentMark.marks > currentMax.marks) {
                maxPerSubject.put(subjectCode, currentMark);
            }
        }
    }