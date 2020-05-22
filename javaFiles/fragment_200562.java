final String fieldValue = d4_text.getText();
if (fieldValue != null && fieldValue.matches("\\d+")) {
    int d4_num = Integer.parseInt(fieldValue);
    ... the rest of your logic that relies on having a correct d4_num value
} else {
    ... output some error message like 'please enter a few digits'
}