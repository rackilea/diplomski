for (int qt = 1; qt <= QRLOG; qt++)
{
    String qrNew = libraryData.getString("CRsaves" + qt, "~~~");
    String qrNewT = libraryData.getString("CRsaves" + qt + "T", "00:00:00");
    String qrNewD = libraryData.getString("CRsaves" + qt + "D", "0000/00/00");
    String qrNewTD = qrNewT + "---" + qrNewD;
    qrLists.add(qrNew);
    qrTimes.add(qrNewTD);
}

for (int bt = 1; bt <= BRlOG; bt++)
{
    String brNew = libraryData.getString("BRsaves" + bt, "~~~");
    String brNewT = libraryData.getString("BRsaves" + bt + "T", "00:00:00");
    String brNewD = libraryData.getString("BRsaves" + bt + "D", "0000/00/00");
    String brNewTD = brNewT + "---" + brNewD;
    barLists.add(brNew);
    barTimes.add(brNewTD);
}