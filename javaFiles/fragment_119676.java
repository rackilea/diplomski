private ClassRepository getGenericInfo() {
    ClassRepository genericInfo = this.genericInfo;
    if (genericInfo == null) {
        String signature = getGenericSignature0();
        if (signature == null) {
            genericInfo = ClassRepository.NONE;
        } else {
            // !!!  RELEVANT LINE HERE:  !!!
            genericInfo = ClassRepository.make(signature, getFactory());
        }
        this.genericInfo = genericInfo;
    }
    return (genericInfo != ClassRepository.NONE) ? genericInfo : null;
}