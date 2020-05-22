boolean found = false;
for (ProjetVTO projetModel : models) {
    if ((projetModel.getAnnee() == model.getAnnee()) && (projetModel.getPriorite().equals(model.getPriorite()))) {
        projetModel.setNbillets(projetModel.getNbillets() + model.getNbillets());
        found = true;
        break;
    }
}
if (!found) {
    models.add(model);
}