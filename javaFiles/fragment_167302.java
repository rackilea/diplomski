for (SemaineTpsRegDto semaine : ecranDto.getListeSemaine()) {
  for (EntiteTpsRegDto entitesTps : semaine.getListeEntite()) {
    for (AgentTpsRegDto agentsTpsReg : entitesTps.getListeAgent()) {
      for (TempsRegJournalierDto tempsRegJour : agentsTpsReg.getListeTempsJournalier()) {
        tempsRegJour.getHeureReelle().getDepassement();
      }
    }
  }    
}