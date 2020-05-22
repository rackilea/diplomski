if (chemin_complet.contains(chemin_commun)) {

    chemin_complet = chemin_complet.split("=")[1];
    inst_value.add(chemin_complet);
    //System.out.println(chemin_complet);
    map_instances.put(chemin_commun, inst_value);

}