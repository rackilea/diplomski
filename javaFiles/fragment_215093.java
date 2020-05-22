Predicate eventTypeIscafeORDJ = cB.or(
    cB.equal(eventType.<String>get("type"), "cafe"),
    cB.equal(eventType.<String>get("type"), "DJ")
);
Predicate timeGreaterOrEqualTo = cB.greaterThanOrEqualTo(eventRoot.<Date>get("time"), cal.getTime());
eQr.where( cB.and( timeGreaterOrEqualTo, eventTypeIscafeORDJ ) );