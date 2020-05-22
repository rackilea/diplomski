public boolean acceptableParameterName(String parameterName) {

            boolean allowedParameterName = true ;

            if ( parameterName.contains("session")  || parameterName.contains("request") ) {

                    allowedParameterName = false ;

            }

            return allowedParameterName;
    }