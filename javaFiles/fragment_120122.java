private void find(Path path) {          
    Path name = path.getFileName();
    if (name != null) {
        if(matcher.matches(name)) {
            System.out.println("Matching file:" + path.getFileName());
        }
    }
}