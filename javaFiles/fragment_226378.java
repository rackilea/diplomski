public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
        case R.id.radLW:
            setGPercentage = 10 * maintCals/100;
            finalGPercentage = maintCals - setGPercentage;
            break;
        case R.id.radLWF:
            setGPercentage = 20 * maintCals/100;
            finalGPercentage = maintCals - setGPercentage;
            break;
        case R.id.radM:
            setGPercentage = 0;
            break;
        case R.id.radGW:
            setGPercentage = 10 * maintCals/100;
            finalGPercentage = maintCals + setGPercentage;
            break;
        case R.id.radGWF:
            setGPercentage = 20 * maintCals/100;
            finalGPercentage = maintCals + setGPercentage;
            break;
        }