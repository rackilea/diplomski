...
// compute interim reasons mask
boolean[] interimReasonsMask = new boolean[9];
ReasonFlags reasons = null;
if (idpExt != null) {
    reasons = (ReasonFlags) idpExt.get(IssuingDistributionPointExtension.REASONS);
}

boolean[] pointReasonFlags = point.getReasonFlags();
if (reasons != null) {
    if (pointReasonFlags != null) {
        // set interim reasons mask to the intersection of
        // reasons in the DP and onlySomeReasons in the IDP
        boolean[] idpReasonFlags = reasons.getFlags();
        for (int i = 0; i < interimReasonsMask.length; i++) {
            interimReasonsMask[i] = (i < idpReasonFlags.length && idpReasonFlags[i])
                    && (i < pointReasonFlags.length && pointReasonFlags[i]);
        }
    } else {
        // set interim reasons mask to the value of
        // onlySomeReasons in the IDP (and clone it since we may
        // modify it)
        interimReasonsMask = reasons.getFlags().clone();
    }
} else if (idpExt == null || reasons == null) {
    if (pointReasonFlags != null) {
        // set interim reasons mask to the value of DP reasons
        interimReasonsMask = pointReasonFlags.clone();
    } else {
        // set interim reasons mask to the special value all-reasons
        Arrays.fill(interimReasonsMask, true);  // ### SEE HERE ###
    }
}

// verify that interim reasons mask includes one or more reasons
// not included in the reasons mask
boolean oneOrMore = false;
for (int i = 0; i < interimReasonsMask.length && !oneOrMore; i++) {
    if (interimReasonsMask[i] && !(i < reasonsMask.length && reasonsMask[i])) {
        oneOrMore = true;
    }
}
if (!oneOrMore) {
    return false;
}
...