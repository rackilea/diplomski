Elements trList = bbd.getElementsByTag("tr");

for (int i = 3; i < trList.size(); i++) {
    System.out.println("----------------- TR START -----------------");
    Elements tdList = trList.get(i).getElementsByTag("td");
    for (int j = 2; j < tdList.size(); j++) {
        System.out.println(tdList.get(j));
    }
    System.out.println("------------------ TR END ------------------");
}