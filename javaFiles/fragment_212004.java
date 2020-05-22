String s1 = "((${adapterKind=VMWARE, resourceKind=VirtualMachine, metric=disk|usage_average}*${this, metric=summary|oversizedVMCount})+${this, metric=summary|poweredOffVMCount})";
Pattern p = Pattern.compile("\\$\\{[^}]*\\}");
Matcher m = p.matcher(s1);
while(m.find())
    //here you have the captured texts, 
    //you can put into array/collection as you like
    System.out.println(m.group());