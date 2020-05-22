int month = 2;
    int day = 23;
    ArrayList<String> zodiacSign = new ArrayList<String>();
    switch (month) {
    case 1:
        if (day < 20) {
            zodiacSign.add("Capricorn");
        } else {
            zodiacSign.add("Aquarius");
        }
        break;
    case 2:
        if (day < 18) {
            zodiacSign.add("Aquarius");
        } else {
            zodiacSign.add("Pisces");
        }
        break;
    case 3:
        if (day < 21) {
            zodiacSign.add("Pisces");
        } else {
            zodiacSign.add("Aries");
        }
        break;
    case 4:
        if (day < 20) {
            zodiacSign.add("Aries");
        } else {
            zodiacSign.add("Taurus");
        }
        break;
    case 5:
        if (day < 21) {
            zodiacSign.add("Taurus");
        } else {
            zodiacSign.add("Gemini");
        }
        break;
    case 6:
        if (day < 21) {
            zodiacSign.add("Gemini");
        } else {
            zodiacSign.add("Cancer");
        }
        break;
    case 7:
        if (day < 23) {
            zodiacSign.add("Cancer");
        } else {
            zodiacSign.add("Leo");
        }
        break;
    case 8:
        if (day < 23) {
            zodiacSign.add("Leo");
        } else {
            zodiacSign.add("Virgo");
        }
        break;
    case 9:
        if (day < 23) {
            zodiacSign.add("Virgo");
        } else {
            zodiacSign.add("Libra");
        }
        break;
    case 10:
        if (day < 23) {
            zodiacSign.add("Libra");
        } else {
            zodiacSign.add("Scorpio");
        }
        break;
    case 11:
        if (day < 22) {
            zodiacSign.add("Scorpio");
        } else {
            zodiacSign.add("Sagittarius");
        }
        break;
    case 12:
        if (day < 22) {
            zodiacSign.add("Sagittarius");
        } else {
            zodiacSign.add("Capricorn");
        }
        break;