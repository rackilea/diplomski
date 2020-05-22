// ...
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(appFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getPath());

            String dirFileName = selectedFile.getPath(); // should come from the fileChooser but isnt working

            String dirFileOutput = JOptionPane.showInputDialog(null, "packetname"); // thats working..

            System.out.println(dirFileName);
            System.out.println(dirFileOutput);

            System.out.println("package " + dirFileOutput + "." + ".zip created\n");
        }