// this is the sequence of transformation starting with the sting builder "a"
List<String> randomValueWithLength14 = 
    Arrays.stream(a.toString().split(";")).filter(x -> x.length() == 14)
        .collect(Collectors.toList());

// this is the for loop shown in your code
for (int i=0; i<randomValueWithLength14.size(); i++){
    String s = randomValueWithLength14.get(i); 
    String distance = a.substring(0,5); 
    String xAngle = s.substring(5,8); 
    String yAngle = s.substring(8,11); 
    String zAngle = s.substring(11,14); 

    //String to int
    iDistance = Integer.parseInt(distance);
    xIAngle = Integer.parseInt(xAngle);
    yIAngle = Integer.parseInt(yAngle);
    zIAngle = Integer.parseInt(zAngle);

}