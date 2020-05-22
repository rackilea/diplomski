JSONObject submit = new JSONObject();
        JSONObject button = new JSONObject();
        String value = "function() {"
                +"this.refreshValidationState(true);"
                +"if (!this.isValid(true)) {"
                +"     this.focus();"
                +"    return;"
                +"}"
                +"this.ajaxSubmit();"
                +"}";
        Method click =new Method(value);
        submit.put("click", click);
        button.put("submit", submit);
        button.toJSONString();