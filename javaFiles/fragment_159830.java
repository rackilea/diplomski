String[] acqurierSystemAlias = properties.getProperty("acqurierSystemAlias").split(",");

List<String> lList=Arrays.asList(acqurierSystemAlias);

boolean found=lList.contains(acqurierSA );
System.out.println(found);