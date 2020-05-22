NumberFormat fmt = new CaseInsensitiveNumberFormat(Locale.US);

System.out.println(fmt.parse("0"));       // 0
System.out.println(fmt.parse("0.00003")); // 3.0E-5
System.out.println(fmt.parse("5e-76"));   // 5.0E-76
System.out.println(fmt.parse("2E-10"));   // 2.0E-10