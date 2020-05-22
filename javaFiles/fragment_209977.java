ArrayList<Ehealth> datalist = new ArrayList<Ehealth> ();

int sum = 0;

while(rs.next()){
    Integer grasimi = rs.getInt("Total_grasimi");
    Integer carbohidrati = rs.getInt("Total_carbohidrati");
    Integer proteine = rs.getInt("Total_proteine");
    Integer calorii = rs.getInt("Total_calorii");

    Ehealth ehealthlist = new Ehealth(grasimi,carbohidrati,proteine,calorii);

    datalist.add(ehealthlist);
}

for (Ehealth ehealth : datalist) {
    sum += ehealth.calorii;
}

System.out.println(sum);