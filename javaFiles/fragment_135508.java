public List<Object> description; //type might be wrong

public MyDate(int year, int month, int day, String descriptionTxt) {
     description = new ArrayList<Object>();
     description.add(year);
     description.add( month);
     description.add(day);
     description.add(descriptionTxt);
}