personen.stream().filter(p -> p.getId() == currentLid.getId()).findFirst().ifPresent(p -> {
    p.setVoornaam(currentLid.getVoornaam());
    p.setAchternaam(currentLid.getAchternaam());
    p.setEmail(currentLid.getEmail());
    p.setEmailOuders(currentLid.getEmailOuders());
    p.setEmail(currentLid.getEmail());
    p.setTelefoonNummer(currentLid.getTelefoonNummer());
    p.setGeboorteDatum(currentLid.getGeboorteDatum());
    p.setBackupTelefoon(currentLid.getBackupTelefoon());
    p.setScore(currentLid.getScore());
    p.setGeslacht(currentLid.getGeslacht());
    p.setRijksregisternummer(currentLid.getRijksregisternummer());
    p.setRol(currentLid.getRol());
    p.setGraad(currentLid.getGraad());
    p.setLocatie(currentLid.getLocatie());
    p.setVerwachteDagen(currentLid.getVerwachteDagen());
    p.setActiviteiten(currentLid.getActiviteiten());
});