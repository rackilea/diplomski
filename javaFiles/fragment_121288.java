public class Keyword {
    private String value;
    private double points;

    ...
}

private Keyword[] keywords = new Keyword[] {
    new Keyword("BLUE", 1.6),
    new Keyword("BLACK", 10.1),
    ...
}

for (String subject : subjectArray) {
    for (Keyword keyword : keywords) {
        if (subject.toUpperCase().contains(keyword.getValue())) {
            System.out.println(keyword.getPoints() + " " + keyword.getValue());
            arrlist.add(keyword.getPoints());
        }
    }
}