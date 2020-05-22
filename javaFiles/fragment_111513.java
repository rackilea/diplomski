boolean cartContainsDifferentTypeVoyage(final String type_voyage) {
    for(Voyage voyage : voyages) {
         if(!type_voyage.equals(voyage.getType_voyage()) {
              return true;
         }
    }
}