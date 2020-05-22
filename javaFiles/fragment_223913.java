public Set<Course> getCourses() {
    Set<Course> result = new HashSet<Course>();
    for (Transcript transcript : transcripts) {
        result.add(transcript.getCourse());
    }
    return result;
}