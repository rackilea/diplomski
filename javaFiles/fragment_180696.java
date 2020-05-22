enum ePalindromResult { NO_PALINDROM, PALINDROM_ODD, PALINDROM_EVEN };
public static ePalindromResult checkForPalindrom(String inputStr) {
  // this uses the org.apache.commons.lang3.StringUtils class: 
  if (inputStr.equals(StringUtils.reverse(inputStr)) {
    if (inputStr.length % 2 == 0) return PALINDROM_EVEN;
    else return PALINDROM_ODD;
  } else return NO_PALINDROM;
}