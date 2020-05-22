String str = "{A={111={i=[a,b,c],ii=[e,f]}, 222={iii=[a,e]}}, B={333={i= [b,c]}}}";

String[] splitStr = str.split(Pattern.quote("}},"));
System.out.println(Arrays.toString(splitStr));

String[] splitStr2 = str.split("}},");
System.out.println(Arrays.toString(splitStr2));