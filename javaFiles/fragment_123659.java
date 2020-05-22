Element tblHeader = doc1.select("table.MasterTable_Web20 tbody").first();
List<DogDetail> data = new ArrayList<>();
for (Element element1 : tblHeader.children()){
    DogDetail dogDetail = new DogDetail();
    dogDetail.setDate(element1.select("td:eq(0)").text());
    dogDetail.setDistance(element1.select("td:eq(1)").text());
    dogDetail.setFin(element1.select("td:eq(4)").text());
    data.add(dogDetail);
}

TableView<DogDetail> table = new TableView<DogDetail>(FXCollections.observableArrayList(data));