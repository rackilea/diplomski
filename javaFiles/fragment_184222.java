String input = "retinol,\"3,7,11,15-tetramethyl-2,4,6,10,14-hexadecapentaenoic acid\",C034534,81485-25-8,\"Carcinoma, Hepatocellular\",MESH:D006528,Cancer|Digestive system disease,,17270033,therapeutic";
String[] output = input.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

for(String s : output){
    System.out.println(s);
}