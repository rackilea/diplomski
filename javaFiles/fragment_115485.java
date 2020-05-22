RadioGroup currencySettingRadioGroup = (RadioGroup) settings_dialog.findViewById(R.id.rg_currency_symbol);

String[] currency_symbols_options_array = getResources().getStringArray(R.array.currency_symbols);
for ( String this_currency_option: currency_symbols_options_array ) {
    RadioButton rb = new RadioButton(this);
    rb.setText(this_currency_option);
    currencySettingRadioGroup.addView(rb);
}