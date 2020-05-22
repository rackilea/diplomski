public float getValue(int id, float num1, float num2){
    float result = 0.0;
    switch (id) {
    case R.id.btnAdd:
        oper = "+";
        result = num2 + num2;
        break;
    case R.id.btnSub:
        oper = "-";
        result = num1 - num2;
        break;
    case R.id.btnMult:
        oper = "*";
        result = num1 * num2;
        break;
    case R.id.btnDiv:
        oper = "/";
        result = num1 / num2;
        break;
    default:
        break;
}
return result;
}