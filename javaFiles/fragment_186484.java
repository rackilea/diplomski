String[] codes = {"abc,pqr,100101,P101001,R108972", "mno, 100101,108972"};
for (String code : codes){
    System.out.println(
            code.replaceAll("\\b[A-Z](\\d+)\\b", "$1")
    );
}