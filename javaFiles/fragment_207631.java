formatter = new DecimalFormat("0.00000E00"); // Want to enforce the sign to appear
sresult = formatter.format(result);
if (!sresult.contains("E-")) { //don't blast a negative sign
    sresult = sresult.replace("E", "E+");
}
System.out.println(sresult);