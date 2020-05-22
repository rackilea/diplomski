String number="2525252212"
Pattern mobileNo= Pattern.compile("\\d{10}");
Matcher matcher = mobileNo.matcher(number);
        if (matcher.matches()) {
            //go on
        } else {
            //Show Dialog 
        }