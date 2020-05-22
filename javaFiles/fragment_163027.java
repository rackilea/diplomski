CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaQuery<Mitarbeiter2> q = cb.createQuery(Mitarbeiter2.class);
        Root<Mitarbeiter2> mit= q.from(Mitarbeiter2.class);

            Path<String> pc_name2 = mit.get("PC_Name");
        Path<String> ip2 = mit.get("IP");
        Path<String> pers_num2 = mit.get("Personalnummer");
        Path<String> name2 = mit.get("Name");
        Path<String> vorname2 = mit.get("Vorname");
        Path<String> telefon2 = mit.get("Telefon");
        Path<String> geburtstag2 = mit.get("Geburtstag");
        Path<String> gruppe2 = mit.get("Gruppe");
        Path<String> mobil2 = mit.get("Mobil");

            Predicate p = cb.conjunction();

        if(isPC_NameSuche()){
            p = cb.and(p, cb.like(pc_name2, this.getWc()+_PC_Name+this.getWc() ));

}
        if(isIPSuche()) {
            p = cb.and(p, cb.like(ip2,this.getWc()+_IP+this.getWc()));
            }
        if(isPersonalnummerSuche()) {
            p = cb.and(p, cb.like(pers_num2, this.getWc()+_Personalnummer+this.getWc() ));}

        if(isNameSuche()){
            p = cb.and(p, cb.like(name2, this.getWc()+_Name+this.getWc()));
            }
        if(isVornameSuche()) {
            p = cb.and(p, cb.like(vorname2, this.getWc()+_Vorname+this.getWc()));}
        if(isTelefonSuche()) {
            p = cb.and(p, cb.like(telefon2, this.getWc()+_Telefon+this.getWc() ));}
        if(isGeburtstagSuche()){
            p = cb.and(p, cb.like(geburtstag2, this.getWc()+_Geburtstag+this.getWc()));}
        if(isGruppeSuche()) {
            p = cb.and(p, cb.like(gruppe2, this.getWc()+_Gruppe+this.getWc()));}
        if(isMobilSuche()) {
            p = cb.and(p, cb.like(mobil2, this.getWc()+_Mobil+this.getWc()));}

        q.where(p);
        q.select(mit);
            List<Mitarbeiter2> ergebnis= EM.createQuery(q).getResultList();