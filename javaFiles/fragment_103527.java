public void fileStoring() throws Exception {
        try (FileWriter fileWriter = new FileWriter("C:\\data\\Mustard.txt", true);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            if (i == 1) {
                printWriter.printf("%-10s %-15s %-15s %-15s %-15s\n", "Sno.", "First Name", "Surname", "Reg.No",
                        "Program of Study");
            }
            printWriter.printf("%-10d %-15s %-15s %-15s %-15s\n", i, txtFname.getText(), txtSname.getText(),
                    txtRegNo.getText(), txtPos.getText()).toString();
        } catch (IOException e) {
            // handle the exception here.
        }

        i++;
    }