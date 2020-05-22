List<Integer> filenames = new ArrayList<>();
for (File child : directoryListing) {
    String filename = child.getName();
    String filename1 = filename.substring(24,30);
    filenames.add(Integer.parseInt(filename1));
}
Collections.sort(filenames);