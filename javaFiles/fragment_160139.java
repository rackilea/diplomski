Pattern regex = Pattern.compile(
    "(?<!             # Make sure there is no...           \n" +
    " &\\#            # &#, followed by                    \n" +
    " [0-9A-F]{0,3}   # zero to three hex digits           \n" +
    ")                # right before the current position. \n" +
    "\\d{3}           # Only then match three digits.", 
    Pattern.COMMENTS);