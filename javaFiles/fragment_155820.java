private static List<String> workList = new ArrayList<String>();

public static void powerSplitt(String equationText) {

    char[] charsList = equationText.toCharArray();

    boolean foundTargetChar = false;
    int index = 0;

    for (int i = 0; i < charsList.length; i++) {
        index = i;
        if (charsList[i] == '^') {

            foundTargetChar = true;
            break;
        }
    }
    if (foundTargetChar) {

        workList.add(equationText.substring(0, index));
        if (index +1 < equationText.length()) {
            powerSplitt(equationText.substring(index+1));
        } else {
            workList.add(equationText);
            return;
        }
    } else {
        workList.add(equationText);
    }

}


public static String generateNullCoeffPolynomeWithDegree(int degree) {
    return "0*x^" + degree;
}

public static String generateAllNullCoeffPolynomesWithDegreeExclusiveBetween(int startDegree, int endDegree) {
    if (startDegree-endDegree <= 1) {
        return "";
    }

    int index = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = startDegree -1; i > endDegree; i--) {
        if (index > 0) {
            builder.append("+");
        }
        builder.append(generateNullCoeffPolynomeWithDegree(i));
        index++;
    }

    return builder.toString();
}

public static String buildPreProcessedPolynome(String initialEquationText) {
    workList.clear();
    powerSplitt(initialEquationText);


    StringBuilder resultBuilder = new StringBuilder();
    assert workList.size() >= 3;
    resultBuilder.append(workList.get(0));

    for (int i = 1; i <= workList.size()-2; i++) {
        int actualPower = Integer.parseInt( workList.get(i).substring(0,1));

        int nextFoundPower = Integer.parseInt( workList.get(i+1).substring(0,1));
        System.out.print("actual power = " + actualPower + " and next power = " + nextFoundPower);
        System.out.println();

        String additionalPolyParts = generateAllNullCoeffPolynomesWithDegreeExclusiveBetween(actualPower, nextFoundPower);
        resultBuilder.append("^" + actualPower);
        resultBuilder.append("+");
        resultBuilder.append(additionalPolyParts);
        resultBuilder.append(workList.get(i).substring(1));

    }

    resultBuilder.append("^" + workList.get(workList.size()-1));
    return resultBuilder.toString();
}

public static void main(String[] args) {
    workList.clear();

    String Str2 = "3.1415x^5+6x^2+12*x-5";

    powerSplitt(Str2);

    for (String part: workList) {
        System.out.println("PART:"  + part);
    }

    System.out.println("-----------------");

    long Start = System.nanoTime();

    String str3 = generateAllNullCoeffPolynomesWithDegreeExclusiveBetween(5, 2);
    System.out.println("all poly = " + str3);

    String preprocessed = buildPreProcessedPolynome(Str2);
    System.out.println("preprocessed = " + preprocessed);

    System.out.println();

    Equation E = new Equation(preprocessed);
    System.out.println("Equation is: " + E.SourceEquation());
    System.out.println("Coefficients :" + E.CaptureCoeff());
    System.out.println("Polynomial Degree: " + E.getDegree());
    double Target = 47.784;
    System.out.println("Equation @ (X:" + Target + ")= " + E.Evaluate(E.CaptureCoeff(), Target).setScale(15, RoundingMode.HALF_UP));
    System.out.println("Elapsed Time: " + String.format("%.20G", (System.nanoTime() - Start) / 1.0e6) + " ms.");
}