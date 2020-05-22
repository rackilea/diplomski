TreeMap<LocalDate,boolean[]> map = this.getDetails()
    .stream()
    .collect(Collectors.toMap(
        dept -> dept.getDateFa(),
        dept -> new boolean[] {  dept.getTypemt().equals(TypeMt.SIP),
                                 dept.getTypemt().equals(TypeMt.DOP),
                                 dept.getTypemt().equals(TypeMt.OPA) },
        (bs,newArray) -> {
            for(int index=0;index<bs.length;index++){
                if(newArray[index]) bs[index]=true;
            }
            return bs;
        },
        TreeMap::new));