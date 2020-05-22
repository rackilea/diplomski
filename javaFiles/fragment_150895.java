String suffix;
suffix = grade.substring(1);
if (suffix.isEmpty()) { // return early if there's no suffix
    return gradeNum;
} else if (gradeNum == 0.0) { // to invalidate F- and F+
    System.out.println("Invalid letter grade");
    return gradeNum;
}
if(suffix.equals("+") && gradeNum != 4.0) // don't increment if grade is A+ (= A = 4.0)
{
    gradeNum = gradeNum + .3;
}
else if (suffix.equals("-"))
{
    gradeNum = gradeNum - .3;
}
return gradeNum;