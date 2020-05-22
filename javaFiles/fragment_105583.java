double aResult = 0; //Double.parseDouble(tvaResult.getText().toString());
double cResult = 0; //Double.parseDouble(tvcResult.getText().toString());
double etResult = 0; //Double.parseDouble(tvetResult.getText().toString());
double beta1Result = 0; //Double.parseDouble(tvbeta1Result.getText().toString());
double phiResult = 0; //Double.parseDouble(tvphiResult.getText().toString());
double MnResult = 0; //Double.parseDouble(tvMnResult.getText().toString());
double phiMnResult = 0; //Double.parseDouble(tvphiMnResult.getText().toString());
switch(view.getId()) {
    case R.id.btnCalc:
    if (Fc <= 4000) {
        beta1Result = (0.85);
    } else if (4000 < Fc && Fc <= 8000) {
        beta1Result = ((0.85)-(0.05 * ((Fc - 4000) / (1000))));
    } else {
        beta1Result = 0.65;
    }
    aResult = ((Fy * As) / (0.85 * Fc * B));
    cResult = (aResult / beta1Result);
    etResult = (((D - cResult) / (cResult)) * 0.003);
    if (etResult >= 0.005) {
        phiResult = (0.9);
    } else if (0.002 <= etResult && etResult < 0.005) {
        phiResult = (0.65 + (etResult - 0.002) * 0.25 / (0.005 - 0.002));
    } else {
        phiResult = (0.00);
    }
    MnResult = (((Fy * As) * (D - (aResult / 2.0))));
    phiMnResult = phiResult * MnResult;
    tvaResult.setText(String.valueOf(aResult));
    tvcResult.setText(String.valueOf(cResult));
    tvetResult.setText(String.valueOf(etResult));
    tvphiResult.setText(String.valueOf(phiResult));
    tvMnResult.setText(String.valueOf(MnResult));
    tvphiMnResult.setText(String.valueOf(phiMnResult));
    break;
}