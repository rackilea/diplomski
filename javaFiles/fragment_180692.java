public void doSomethingElseToStrings() {
        try{
        StringTokenizer splitString1 = new StringTokenizer(lines[0]);
        newLines[0] = splitString1.nextToken();
        for(int count=0;count<=splitString1.countTokens();count++) {
            if(count == 0) {
            newLines[0] = newLines[0].concat(" 111");
        }
            newLines[0] = newLines[0].concat(" ");
            newLines[0] = newLines[0].concat(splitString1.nextToken());

        }
        } catch(ArrayIndexOutOfBoundsException ex) {

        }

        try {
        StringTokenizer splitString2 = new StringTokenizer(lines[1]);
        newLines[1] = splitString2.nextToken();
        for(int count=0;count<=splitString2.countTokens();count++) {
            if(count == 1) {
            newLines[1] = newLines[1].concat(" 222");
        }
            newLines[1] = newLines[1].concat(" ");
            newLines[1] = newLines[1].concat(splitString2.nextToken());

        }
        } catch(ArrayIndexOutOfBoundsException ex) {

        }


        try {

            writeFile(yourFile);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            Logger.getLogger(AddText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }