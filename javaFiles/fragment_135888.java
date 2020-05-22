} else if (!(tm.getSimState() == TelephonyManager.SIM_STATE_ABSENT
        || (tm.getSimOperator())
        .equals(getString(R.string.numeric_tmo)) || (tm
                .getSimOperator()).equals(getString(R.string.numeric_att)))) {

        // if SIM is present and is NOT a T-Mo network SIM,
        // display Error message alert indicating to use SM SIM
        showAlert(getString(R.string.insert_sm_dialog));
}// No SIM or SIM with T-Mo MNC MCC present