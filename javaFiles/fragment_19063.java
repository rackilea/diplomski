public ValidationError(String errorCode, String details, Throwable cause)
    {
        this(errorCode);
        if (details != null)
        {
            StringBuilder sb = new StringBuilder(this.details.length() + details.length() + 2);
            sb.append(this.details).append(", ").append(details);
            // invoke intern
            this.details = sb.toString().intern();
        }
        this.cause = cause;
        t = new Exception();
    }