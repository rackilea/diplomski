public Map<LocalDate,boolean[]> getForkedDetails() {
    TreeMap<LocalDate,boolean[]> map=new TreeMap<>();

    this.getDetails().forEach(dept -> {
        boolean[] myArray= { dept.getTypemt().equals(TypeMt.SIP),
                             dept.getTypemt().equals(TypeMt.DOP),
                             dept.getTypemt().equals(TypeMt.OPA) };
        map.merge(dept.getDateFa(), myArray, (bs,newArray) -> {
            for(int index=0;index<bs.length;index++){
                if(newArray[index]) bs[index]=true;
            }
            return bs;
        });
    });

    // add entries for all missing dates between start and end dates
    Stream.iterate(this.getDateDebut(), date -> date.plusDays(1))
          .limit(ChronoUnit.DAYS.between(this.getDateDebut(), this.getDateFin()))
          .forEach(date-> map.computeIfAbsent(date, key -> new boolean[3]));

    // the TreeMap is already sorted
    return map;
}