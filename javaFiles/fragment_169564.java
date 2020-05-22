public double sumInputs(double totalValue) {
    EditText[] inputs = {mPtEditText, mRebEditText,
            mAssEditText, mStlEditText, mBlkEditText};

    double sum = 0.0;
    for (int i = 0; i < inputs.length; i++)
        sum = sum + Double.parseDouble(inputs[i].getResources().toString());

    return totalValue - sum;
}