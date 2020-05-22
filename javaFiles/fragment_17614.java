boolean isMatch = false;
String matchedNumber = null;

for (String currentNumber : listItem.getNumbers ()) {
    PhoneNumberUtil.MatchType mt = pnu.isNumberMatch (currentNumber, number);
    if (mt == PhoneNumberUtil.MatchType.NSN_MATCH || mt == PhoneNumberUtil.MatchType.SHORT_NSN_MATCH || mt == PhoneNumberUtil.MatchType.EXACT_MATCH) {
        isMatch = true;
        matchedNumber = currentNumber;

        break;
    }
}

if (isMatch) {
    // your business logic
}