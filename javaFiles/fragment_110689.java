if (value && XalanConstants.IS_JDK8_OR_ABOVE) {
    _xmlSecurityPropertyMgr.setValue(
         Property.ACCESS_EXTERNAL_DTD, 
         State.FSP, 
         XalanConstants.EXTERNAL_ACCESS_DEFAULT_FSP
    ); // ACCESS_EXTERNAL_DTD is disabled by setting to the default value
 }