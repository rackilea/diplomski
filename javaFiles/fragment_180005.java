PrimaryTest[] response = gson.fromJson(json, PrimaryTest[].class);
List<PrimaryTest> lstTest = Arrays.asList(response);
PrimaryTest objTest = lstTest.get(0);

List<Option> options = objTest.getOptions();
for(Option option : options){
    System.out.println(option.getOption());
}