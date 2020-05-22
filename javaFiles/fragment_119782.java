val str = "12+20*/2-4";
val arr = str.split("\\p{Punct}".toRegex());
//  ^--- but the result is ["12","20","","2","4"]

val arr2 = arr.filter{ !it.isBlank() };
//  ^--- you can filter it as further, and result is: ["12","20","2","4"]