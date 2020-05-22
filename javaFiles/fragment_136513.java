Elements tables = document.select("table[class=MsoNormalTable] tbody");

int index = 0;
for(Element table : tables){
    System.out.println("Table : " + (++index) + " has " + table.select("tr").size() + " rows.");
}