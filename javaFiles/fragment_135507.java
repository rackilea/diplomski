public Map<String,Object> description; //type might be wrong

public MyDate(int year, int month, int day, String descriptionTxt) {
     description = new HashMap<String, Object>();
     description.put("year", year);
     description.put("month", month);
     description.put("day", day);
     description.put("desc", descriptionTxt);
}