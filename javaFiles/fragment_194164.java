public Map<String, CodaReportDTO> dateAndDTO = new HashMap<>(); //hashmap for date and the dto


Set<Entry<String, CodaReportDTO>> entrySet = dateAndDTO.entrySet();

for(Entry<String, CodaReportDTO> entry : entrySet){
    entry.getKey(); //your String key i.e. date in your case
    entry.getValue(); //your DTO value for this key
    ...
}