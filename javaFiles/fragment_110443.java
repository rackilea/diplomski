protected By getInput() {
        return input;
    }

    protected String getValue() {
        return value;
    }

    protected WebElement getInputElement() {
        return inputElement;
    }

    protected WebElement getErrorElement() {
        return errorElement;
    }

    protected void setValue(String value){
        this.value = value;
        if(inputElement == null){
            inputElement = driver.findElement(input);
        }

        inputElement.clear();
        inputElement.sendKeys(value);
    }

    protected void clear(){
        if(inputElement == null){
            inputElement = driver.findElement(input);
        }

        inputElement.clear();
    }

    protected void setValue(){
        setValue(this.value);
    }

    /**
     * Checks if there is currently an error message.
     * 
     * @param input
     * @return true if an error exists for this element. 
     */
    public boolean hasError(){
        errorElement = elementExistsInContext(inputElement, errorField);
        if(errorElement == null){
            return false;
        }
        return true;
    }

    protected InputElement(By input, By errorField){
        this.input = input;
        this.errorField = errorField;
    }

    protected InputElement(By input, By errorField, String value){
        this.input = input;
        this.errorField = errorField;
        this.value = value;
    }
}