...
  String latex = "$a^2 + b^2 = c^2$";

  uk.ac.ed.ph.snuggletex.SnuggleEngine engine = new uk.ac.ed.ph.snuggletex.SnuggleEngine();
  uk.ac.ed.ph.snuggletex.SnuggleSession session = engine.createSession();
  uk.ac.ed.ph.snuggletex.SnuggleInput input = new uk.ac.ed.ph.snuggletex.SnuggleInput(latex);
  session.parseInput(input);
  String mathML = session.buildXMLString();
System.out.println(mathML);

/*
  String mathML = fmath.conversion.ConvertFromLatexToMathML.convertToMathML(latex);
  mathML = mathML.replaceFirst("<math ", "<math xmlns=\"http://www.w3.org/1998/Math/MathML\" ");
System.out.println(mathML);
*/

  CTOMath ctOMath = getOMML(mathML);
System.out.println(ctOMath);

...

  latex = "$x=\\frac{-b\\pm\\sqrt{b^2-4ac}}{2a}$";

  engine = new uk.ac.ed.ph.snuggletex.SnuggleEngine();
  session = engine.createSession();
  input = new uk.ac.ed.ph.snuggletex.SnuggleInput(latex);
  session.parseInput(input);
  mathML = session.buildXMLString();
System.out.println(mathML);

/*
  mathML = fmath.conversion.ConvertFromLatexToMathML.convertToMathML(latex);
  mathML = mathML.replaceFirst("<math ", "<math xmlns=\"http://www.w3.org/1998/Math/MathML\" ");
  mathML = mathML.replaceAll("&plusmn;", "±");
System.out.println(mathML);
*/

  ctOMath = getOMML(mathML);
System.out.println(ctOMath);
...