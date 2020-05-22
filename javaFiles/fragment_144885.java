for (int i = 0; i < fileContent.length; i += 4) {

        fileContentLeft[i] = fileContent[i];
        fileContentLeft[i + 1] = fileContent[i + 1];
        fileContentRight[i + 2] = fileContent[i + 2];
        fileContentRight[i + 3] = fileContent[i + 3];

    }
}