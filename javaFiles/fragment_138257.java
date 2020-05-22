public void monthlyProcess() {
    int w = getWithdrawals();
    if (w > 4) {
        serCharge += w - 4;
    }
    super.monthlyProcess();
    if(bal <= MIN_BAL) {
        status = false;
    }
}