for (File file : listOfFiles) {
            Matcher match = wildCardPattern.matcher(file.getName());
            if (match.matches()) {
                fileList.add(file);
            }
        }