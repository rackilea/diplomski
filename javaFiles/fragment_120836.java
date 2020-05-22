List<String> newList =  new ArrayList<>();

for(String s: CaseManagersreceivingreminders) {
    s = s.replaceAll("\\(.*\\)", "");
    newList.add(s);
}

System.out.println(newList);