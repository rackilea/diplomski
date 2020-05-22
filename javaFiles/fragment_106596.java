String test = "A,B,,,C,,";

String[] result = test.split(",",test.length()); // or the number of elements you expect in the result

for(String s : result){
    System.out.println("$"+s+"$");
}