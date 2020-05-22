BigDecimal annualPremiumAmt;
for(...) { 

    if (nwtPremium) {
        annualPremiumAmt = nwtPremium.getAnnualAmt() != null ? nwtPremium.getAnnualAmt() : BigDecimal.ZERO;
        policyFormTotal = policyFormTotal.add(annualPremiumAmt);
        formList.setFormPremiumAmt(formList.getFormPremiumAmt().add(annualPremiumAmt));
    }
}