Element indiaTable = doc.select("table").get(2); //India table is the third (index is 2) table on page
Elements myTds = indiaTable.select("td:eq(0)"); //The states are the first column

//or you can replace the two lines of code above with this

Elements myTds = doc.select("table.wikitable td:eq(0)");



for (Element td: myTds ) {
    System.out.println(td.text());
}