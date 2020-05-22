String [][] matrix =  { {"10","20","OK"}, {"5","30","KO"}, {"20","100","NA"}, {"10","60","OK"} };

for (String [] line : matrix) {
    for (String s: line) {
        System.out.print ("10 " + s);
    }
}