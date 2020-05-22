final Long idBeneficiaire = context.getIdPersonne();
final Map<Long, List<PensionMediumView>> mapPensionsBeneficiaire = this.pensionBusinessApplicatif
    .recupererPensionsActivesParBeneficiaires(
    Arrays.asList(idBeneficiaire),
    context.getIdentificationContext());
for (final Map.Entry<Long, List<PensionMediumView>> entry : mapPensionsBeneficiaire.entrySet()){
    for(PensionMediumView pension : enter.getValue()) {
        // I wasn't sure of how to get the pension id from your example
        // So just replace this with example getter with however you get your pension ID
        if(pension.typePensionId() == 21) {
            System.out.println("Error!");
            break; // This will stop the loop, 
            // if you want the loop to continue, don't use this
        }
    }
}