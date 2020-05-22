......
 Sortie sortie = new Sortie();
 sortie.setUtilisateur(userService.findUserByUsername(getPseudoCo()));
 sortie.setRecepteur(commande.getUtilisateur());
 Sortie exit = sortieService.addSortie(sortie);
 sortieService.updateSortieRecepteur(exit, commande.getUtilisateur());
 ......