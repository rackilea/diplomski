if (grade == null || !grade.matches("[A-F][+-]?")) // if grade wasn't specified, or
{// if grade is not between A to F *optionally* followed by a + or - sign
    System.out.println("Invalid letter grade");
    return gradeNum;
}

String letterGrade = grade.substring(0, 1); // pass 1 to exclude + or -

if (letterGrade.equalsIgnoreCase("A"))
{
    gradeNum = 4.0;
}
else if(letterGrade.equalsIgnoreCase("B"))
{
    gradeNum = 3.0;
}
else if(letterGrade.equalsIgnoreCase("C"))
{
  gradeNum = 2.0;
}
else if(letterGrade.equalsIgnoreCase("D"))
{
    gradeNum = 1.0;
}
else if(letterGrade.equalsIgnoreCase("F"))
{
    gradeNum = 0.0; // return from here if you want F = F- = F+
    return gradeNum; // if you want to invalidate F- and F+ look below
}
/* else // not required; already validated by using regex above
{
    System.out.println("Invalid letter grade");
    return gradeNum; // don't forget to RETURN from here
}*/