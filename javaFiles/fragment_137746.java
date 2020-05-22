if (Enhancer.isEnhanced(getClass())) {
    currClass = UnEnhancer.unenhance(getClass());
 } else {
    // else, let's get the original class directly
    currClass = getClass();
 }