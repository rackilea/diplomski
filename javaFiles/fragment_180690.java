public void doSomethingToStrings() {
        try {

            lines[0] = lines[0].concat(" ddd"); //this joins the two strings lines[0] and " ddd"

        } catch (ArrayIndexOutOfBoundsException ex) { // I have added a try{}catch{} block so that if there is not as many lines in the file as expected, the code will still continue.

        }
        try {
            lines[1] = lines[1].concat(" hhh");
        } catch (ArrayIndexOutOfBoundsException ex) {

        }



        try {

            writeFile(yourFile);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            Logger.getLogger(AddText.class.getName()).log(Level.SEVERE, null, ex);
        }

    }