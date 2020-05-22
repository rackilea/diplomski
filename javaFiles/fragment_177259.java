LinkedHashMap<Integer, List<MyDTO>> myResults =  myService.getResultData(myDTO);

 for (Map.Entry results : myResults.entrySet()) {
     List<MyDTO> myDTOList = (List<MyDTO>) results.getValue();
        Date minDate, maxDate;
        for(int i=0; i < myDTOList.size(); i++){
            if(i == 0){
                 minDate = myDTOList.get(0).getMyDate();
                 maxDate = myDTOList.get(0).getMyDate();
            }
            if(myDTOList.get(i).before(minDate)){
                minDate = dates.get(i);
            }
            if(myDTOList.get(i).after(maxDate)){
                maxDate = dates.get(i);
            }
        }

        System.out.println("Min date is ---"+minDate);
        System.out.println("Max date is ---"+maxDate);

}