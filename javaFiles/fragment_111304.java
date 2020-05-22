if ( obj instanceof Child ) {
    ((Child) obj).aChildMethod();
    // or
    Child childObj = (Child) obj;
    childObj.aChildMethod();
}