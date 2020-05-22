EditText basis = (EditText)findViewById(R.id.Basis);
String tussenBasis = basis.getText().toString();
double basisDouble = Double.valueOf(tussenBasis);
//

EditText hoogte = (EditText)findViewById(R.id.Hoogte);
String tussenHoogte = hoogte.getText().toString();
double hoogteDouble = Double.valueOf(tussenHoogte);

double half = 1d / 2d;
//half = 0,5

double einde = half * basisDouble * hoogteDouble;