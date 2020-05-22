private void calculate(int aInvoerGetal) {
    if (addition)
        totalNumber += aInvoerGetal;
    else if (substract)
        totalNumber -= aInvoerGetal;
    else if (divide)
        totalNumber /= aInvoerGetal;
    else if (multiply)
        totalNumber *= aInvoerGetal;

    resetFlags();
}