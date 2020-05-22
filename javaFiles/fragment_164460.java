// if the strict validation off then we consider all elements have minOccurs zero on it
if (this.options.isOffStrictValidation()){
    metainfHolder.addMinOccurs(referencedQName, 0);
} else {
    metainfHolder.addMinOccurs(referencedQName, elt.getMinOccurs());
}