import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Consultation{

@SerializedName("consultation_id")
@Expose
private Integer consultationId;
@SerializedName("plageconsult_id")
@Expose
private Integer plageconsultId;
@SerializedName("patient_id")
@Expose
private Integer patientId;
@SerializedName("heure")
@Expose
private String heure;
@SerializedName("duree")
@Expose
private Integer duree;
@SerializedName("motif")
@Expose
private Object motif;
@SerializedName("secteur1")
@Expose
private Integer secteur1;
@SerializedName("secteur2")
@Expose
private Integer secteur2;
@SerializedName("rques")
@Expose
private String rques;
@SerializedName("chrono")
@Expose
private String chrono;
@SerializedName("annule")
@Expose
private String annule;
@SerializedName("patient_date_reglement")
@Expose
private Object patientDateReglement;
@SerializedName("examen")
@Expose
private Object examen;
@SerializedName("traitement")
@Expose
private String traitement;
@SerializedName("histoire_maladie")
@Expose
private Object histoireMaladie;
@SerializedName("conclusion")
@Expose
private Object conclusion;
@SerializedName("premiere")
@Expose
private String premiere;
@SerializedName("derniere")
@Expose
private String derniere;
@SerializedName("tarif")
@Expose
private Object tarif;
@SerializedName("patient_mode_reglement")
@Expose
private Object patientModeReglement;
@SerializedName("arrivee")
@Expose
private String arrivee;
@SerializedName("codes_ccam")
@Expose
private Object codesCcam;
@SerializedName("banque_id")
@Expose
private Object banqueId;
@SerializedName("categorie_id")
@Expose
private Object categorieId;
@SerializedName("adresse")
@Expose
private String adresse;
@SerializedName("valide")
@Expose
private String valide;
@SerializedName("total_amc")
@Expose
private Object totalAmc;
@SerializedName("total_amo")
@Expose
private Object totalAmo;
@SerializedName("total_assure")
@Expose
private Object totalAssure;
@SerializedName("du_patient")
@Expose
private Integer duPatient;
@SerializedName("sejour_id")
@Expose
private Integer sejourId;
@SerializedName("du_tiers")
@Expose
private Integer duTiers;
@SerializedName("tiers_mode_reglement")
@Expose
private Object tiersModeReglement;
@SerializedName("tiers_date_reglement")
@Expose
private Object tiersDateReglement;
@SerializedName("date_at")
@Expose
private Object dateAt;
@SerializedName("concerne_ALD")
@Expose
private String concerneALD;
@SerializedName("facture")
@Expose
private String facture;
@SerializedName("adresse_par_prat_id")
@Expose
private Object adresseParPratId;
@SerializedName("si_desistement")
@Expose
private String siDesistement;
@SerializedName("fin_at")
@Expose
private Object finAt;
@SerializedName("pec_at")
@Expose
private Object pecAt;
@SerializedName("reprise_at")
@Expose
private Object repriseAt;
@SerializedName("type")
@Expose
private String type;
@SerializedName("grossesse_id")
@Expose
private Object grossesseId;
@SerializedName("at_sans_arret")
@Expose
private String atSansArret;
@SerializedName("arret_maladie")
@Expose
private String arretMaladie;
@SerializedName("factureconsult_id")
@Expose
private Object factureconsultId;
@SerializedName("brancardage")
@Expose
private Object brancardage;
@SerializedName("sianesthesique")
@Expose
private Integer sianesthesique;

public Integer getConsultationId() {
return consultationId;
}

public void setConsultationId(Integer consultationId) {
this.consultationId = consultationId;
}

public Integer getPlageconsultId() {
return plageconsultId;
}

public void setPlageconsultId(Integer plageconsultId) {
this.plageconsultId = plageconsultId;
}

public Integer getPatientId() {
return patientId;
}

public void setPatientId(Integer patientId) {
this.patientId = patientId;
}

public String getHeure() {
return heure;
}

public void setHeure(String heure) {
this.heure = heure;
}

public Integer getDuree() {
return duree;
}

public void setDuree(Integer duree) {
this.duree = duree;
}

public Object getMotif() {
return motif;
}

public void setMotif(Object motif) {
this.motif = motif;
}

public Integer getSecteur1() {
return secteur1;
}

public void setSecteur1(Integer secteur1) {
this.secteur1 = secteur1;
}

public Integer getSecteur2() {
return secteur2;
}

public void setSecteur2(Integer secteur2) {
this.secteur2 = secteur2;
}

public String getRques() {
return rques;
}

public void setRques(String rques) {
this.rques = rques;
}

public String getChrono() {
return chrono;
}

public void setChrono(String chrono) {
this.chrono = chrono;
}

public String getAnnule() {
return annule;
}

public void setAnnule(String annule) {
this.annule = annule;
}

public Object getPatientDateReglement() {
return patientDateReglement;
}

public void setPatientDateReglement(Object patientDateReglement) {
this.patientDateReglement = patientDateReglement;
}

public Object getExamen() {
return examen;
}

public void setExamen(Object examen) {
this.examen = examen;
}

public String getTraitement() {
return traitement;
}

public void setTraitement(String traitement) {
this.traitement = traitement;
}

public Object getHistoireMaladie() {
return histoireMaladie;
}

public void setHistoireMaladie(Object histoireMaladie) {
this.histoireMaladie = histoireMaladie;
}

public Object getConclusion() {
return conclusion;
}

public void setConclusion(Object conclusion) {
this.conclusion = conclusion;
}

public String getPremiere() {
return premiere;
}

public void setPremiere(String premiere) {
this.premiere = premiere;
}

public String getDerniere() {
return derniere;
}

public void setDerniere(String derniere) {
this.derniere = derniere;
}

public Object getTarif() {
return tarif;
}

public void setTarif(Object tarif) {
this.tarif = tarif;
}

public Object getPatientModeReglement() {
return patientModeReglement;
}

public void setPatientModeReglement(Object patientModeReglement) {
this.patientModeReglement = patientModeReglement;
}

public String getArrivee() {
return arrivee;
}

public void setArrivee(String arrivee) {
this.arrivee = arrivee;
}

public Object getCodesCcam() {
return codesCcam;
}

public void setCodesCcam(Object codesCcam) {
this.codesCcam = codesCcam;
}

public Object getBanqueId() {
return banqueId;
}

public void setBanqueId(Object banqueId) {
this.banqueId = banqueId;
}

public Object getCategorieId() {
return categorieId;
}

public void setCategorieId(Object categorieId) {
this.categorieId = categorieId;
}

public String getAdresse() {
return adresse;
}

public void setAdresse(String adresse) {
this.adresse = adresse;
}

public String getValide() {
return valide;
}

public void setValide(String valide) {
this.valide = valide;
}

public Object getTotalAmc() {
return totalAmc;
}

public void setTotalAmc(Object totalAmc) {
this.totalAmc = totalAmc;
}

public Object getTotalAmo() {
return totalAmo;
}

public void setTotalAmo(Object totalAmo) {
this.totalAmo = totalAmo;
}

public Object getTotalAssure() {
return totalAssure;
}

public void setTotalAssure(Object totalAssure) {
this.totalAssure = totalAssure;
}

public Integer getDuPatient() {
return duPatient;
}

public void setDuPatient(Integer duPatient) {
this.duPatient = duPatient;
}

public Integer getSejourId() {
return sejourId;
}

public void setSejourId(Integer sejourId) {
this.sejourId = sejourId;
}

public Integer getDuTiers() {
return duTiers;
}

public void setDuTiers(Integer duTiers) {
this.duTiers = duTiers;
}

public Object getTiersModeReglement() {
return tiersModeReglement;
}

public void setTiersModeReglement(Object tiersModeReglement) {
this.tiersModeReglement = tiersModeReglement;
}

public Object getTiersDateReglement() {
return tiersDateReglement;
}

public void setTiersDateReglement(Object tiersDateReglement) {
this.tiersDateReglement = tiersDateReglement;
}

public Object getDateAt() {
return dateAt;
}

public void setDateAt(Object dateAt) {
this.dateAt = dateAt;
}

public String getConcerneALD() {
return concerneALD;
}

public void setConcerneALD(String concerneALD) {
this.concerneALD = concerneALD;
}

public String getFacture() {
return facture;
}

public void setFacture(String facture) {
this.facture = facture;
}

public Object getAdresseParPratId() {
return adresseParPratId;
}

public void setAdresseParPratId(Object adresseParPratId) {
this.adresseParPratId = adresseParPratId;
}

public String getSiDesistement() {
return siDesistement;
}

public void setSiDesistement(String siDesistement) {
this.siDesistement = siDesistement;
}

public Object getFinAt() {
return finAt;
}

public void setFinAt(Object finAt) {
this.finAt = finAt;
}

public Object getPecAt() {
return pecAt;
}

public void setPecAt(Object pecAt) {
this.pecAt = pecAt;
}

public Object getRepriseAt() {
return repriseAt;
}

public void setRepriseAt(Object repriseAt) {
this.repriseAt = repriseAt;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Object getGrossesseId() {
return grossesseId;
}

public void setGrossesseId(Object grossesseId) {
this.grossesseId = grossesseId;
}

public String getAtSansArret() {
return atSansArret;
}

public void setAtSansArret(String atSansArret) {
this.atSansArret = atSansArret;
}

public String getArretMaladie() {
return arretMaladie;
}

public void setArretMaladie(String arretMaladie) {
this.arretMaladie = arretMaladie;
}

public Object getFactureconsultId() {
return factureconsultId;
}

public void setFactureconsultId(Object factureconsultId) {
this.factureconsultId = factureconsultId;
}

public Object getBrancardage() {
return brancardage;
}

public void setBrancardage(Object brancardage) {
this.brancardage = brancardage;
}

public Integer getSianesthesique() {
return sianesthesique;
}

public void setSianesthesique(Integer sianesthesique) {
this.sianesthesique = sianesthesique;
}

}