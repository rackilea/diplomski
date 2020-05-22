while (fileScan.hasNextLine()) {
            lineC++;
            tempo = fileScan.nextLine();
            StringTokenizer st = new StringTokenizer(tempo, "[ .,:;()?!]+");
            wordC += st.countTokens();
            while(st.hasMoreTokens()) {
                String stt = st.nextToken();
                System.out.println(stt); // Displaying string to confirm that like is splitted as I expect it to be
                charC += stt.length();
            }
            System.out.println("Lines: " + lineC + "\nWords: " + wordC+" \nChars: "+charC);
        }