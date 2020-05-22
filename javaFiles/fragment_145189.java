"buttons": {
        "submit": {
            "click": function() {
                this.refreshValidationState(true);
                if (!this.isValid(true)) {
                    this.focus();
                    return;
                }
                this.ajaxSubmit();
            }
        }
    }