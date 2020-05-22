int themeId = getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.theme;


switch (themeId)
        {
        default:
        case THEME_DEFAULT: // use the theme names in cases as per requirements
            break;
        case THEME_WHITE:
            activity.setTheme(R.style.Theme_White);
            break;
        case THEME_BLUE:
            activity.setTheme(R.style.Theme_Blue);
            break;
        }