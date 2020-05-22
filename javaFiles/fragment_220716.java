for (int i = 'A'; i <= 'Z'; i++)
    for (fileName: fileNameList) {
        if ((int)fileName.charAt(0) == i) {
            AlphabetList.add((char)i);
        }
    }
}