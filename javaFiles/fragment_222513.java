static final Pattern DIGIT_0 = Pattern.compile("[٠۰߀०০੦૦୦௦౦೦൦๐໐０]");
static final Pattern DIGIT_1 = Pattern.compile("[١۱߁१১੧૧୧௧౧೧൧๑໑１]");
static final Pattern DIGIT_2 = Pattern.compile("[٢۲߂२২੨૨୨௨౨೨൨๒໒２]");
static final Pattern DIGIT_3 = Pattern.compile("[٣۳߃३৩੩૩୩௩౩೩൩๓໓３]");
static final Pattern DIGIT_4 = Pattern.compile("[٤۴߄४৪੪૪୪௪౪೪൪๔໔４]");
static final Pattern DIGIT_5 = Pattern.compile("[٥۵߅५৫੫૫୫௫౫೫൫๕໕５]");
static final Pattern DIGIT_6 = Pattern.compile("[٦۶߆६৬੬૬୬௬౬೬൬๖໖６]");
static final Pattern DIGIT_7 = Pattern.compile("[٧۷߇७৭੭૭୭௭౭೭൭๗໗７]");
static final Pattern DIGIT_8 = Pattern.compile("[٨۸߈८৮੮૮୮௮౮೮൮๘໘８]");
static final Pattern DIGIT_9 = Pattern.compile("[٩۹߉९৯੯૯୯௯౯೯൯๙໙９��]");

public static final Pattern[] DIGIT_PATTERN_LIST = { DIGIT_0, DIGIT_1, DIGIT_2, DIGIT_3, DIGIT_4, DIGIT_5, DIGIT_6, DIGIT_7, DIGIT_8,
        DIGIT_9 };

/**
 * Converts any Unicode digits into their ASCII equivalent. For example given 23۹٤۴ returns 23944
 * 
 * @param str
 * @return
 */
public static String normalizeUnicodeDigits(String str) {
    for (int i = 0; i < DIGIT_PATTERN_LIST.length; i++) {
        Pattern dp = DIGIT_PATTERN_LIST[i];
        str = dp.matcher(str).replaceAll(String.valueOf(i));
    }
    return str;
}