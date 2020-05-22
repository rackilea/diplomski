Map<File, String> map = Arrays.stream(filenames)
    .map(s -> FileUtils.listFiles(new File(rootdir, s), new RegexFileFilter(".*"), DirectoryFileFilter.DIRECTORY))
    .flatMap(Collection::stream)
    .collect(Collectors.toMap(
        Function.identity(),
        f-> {
            try { return FileUtils.readFileToString(f); }
            catch (IOException ioe) { return null; }
        }
    ));