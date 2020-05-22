ligne = buff.readLine();
        while (ligne != null) {
            String[] objetSalle = ligne.split(",");
            nom = objetSalle[0];
            String capacite_maxString = objetSalle[1];
            Integer capacite_max = Integer.parseInt(capacite_maxString);
            String capacite_actuelleString = objetSalle[3];
            Integer capacite_actuelle = Integer.parseInt(capacite_actuelleString);
            String proprietaire = objetSalle[2];
            salle = new Salle();
            salle.setNom(nom);
            salle.setCapacite_max(capacite_max);
            salle.setCapacite_actuelle(capacite_actuelle);
            if(proprietaire == null || proprietaire == "" || proprietaire.equals("null")) {
                salle.setEstReserve(Boolean.FALSE);
            } else {
                salle.setEstReserve(Boolean.FALSE);
            }
            listeSalles.add(salle);
            ligne = buff.readLine(); // add this
        }