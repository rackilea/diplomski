StringBuilder textRegion = new StringBuilder();

        String txt = JOptionPane.showInputDialog(null,
                textRegion.append(Arrays.toString(firstDataArray).replace("[", "").replace("]", "").replace(",", "")).append('\n'), "Choose Option)",
                JOptionPane.PLAIN_MESSAGE);
        //If the user click cancel , show the other array in a new JoptionPane   
        if (txt == null) {
            textRegion = new StringBuilder(); // <--- 
            txt = JOptionPane.showInputDialog(null,
                    textRegion.append(Arrays.toString(secondDataArray).replace("[", "").replace("]", "").replace(",", "")).append('\n'), "Choisir municipalite (Chose option)",
                    JOptionPane.PLAIN_MESSAGE);


                //If the user click cancel again , show the other array in a third JoptionPane  
                if (txt == null) {
                textRegion = new StringBuilder(); // <---

                txt = JOptionPane.showInputDialog(null,
                        textRegion.append(Arrays.toString(thirdDataArray).replace("[", "").replace("]", "").replace(",", "")).append('\n'), "Chose Option)",
                        JOptionPane.PLAIN_MESSAGE);
                if (txt == null) {

                } else {
                    setNomMunicipalite(txt);
                }

            } else {
                setNomMunicipalite(txt);
            }
        } else {
            setNomMunicipalite(txt);
        }