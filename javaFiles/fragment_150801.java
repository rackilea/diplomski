if (chemin_complet.contains(chemin_commun)) {

    ArrayList<String> currentList = map_instances.get(chemin_commun);

    if ( currentList == null ) {
         // This is the first time we see this chemin_commun, so
         // Create a new list for it and put it in the map.
         currentList = new ArrayList<>();
         map_instances.put(chemin_commun, currentList );
    }

    // At this point currentList is never null. It is the specific list
    // that is mapped by the current chemin_commun. So add the value
    // to this list
    chemin_complet = chemin_complet.split("=")[1];
    currentList.add(chemin_complet);

}