PDCheckbox fullTimeSalary = (PDCheckbox) pdAcroForm.getField("fullTimeSalary");
if(fullTimeSalary.isChecked()) {
    log.debug("The person earns a full-time salary");
} else {
    log.debug("The person does not earn a full-time salary");
}