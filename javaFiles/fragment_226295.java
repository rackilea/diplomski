private List<mystatistik> getAllUniqueEnemies(List<mystatistik> list){
    List<mystatistik> uniqueList = new ArrayList<mystatistik>();
    List<String> enemyIds = new ArrayList<String>();
    for (mystatistik entry : list){
        if (!enemyIds.contains(entry.getEnemyId())){
            enemyIds.add(entry.getEnemyId());
            uniqueList.add(entry);
        }
    }
    return uniqueList;
}