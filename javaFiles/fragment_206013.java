...
        } catch (Exception ex) {
            requete.fermer();

            fichierIndius.fermerSansException();
            fichierIndius2.fermerSansException();
            cnnAS400.fermerConnexion();
            cnnAS400FO.fermerConnexion();
            cnnOracle.fermerConnexion();
            System.err
                    .println("Erreur d'écriture dans le fichier d'indus! /        EXC : "
                            + ex);
            return;
        }
        finally{
...