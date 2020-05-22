public Integer highestMark() {
    return Collections.max(this.getMarks());
}


studentData.stream().sorted((s1, s2) -> s1.highestMark().compareTo(s2.highestMark())).findFirst().get();