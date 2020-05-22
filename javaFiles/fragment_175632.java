switch (s) {
        case "m": print(); continue;
        case "s": stat(); break;
        case "q": return;
        default:
            if (s.matches("[A-Z]{1}[a-z]{2}\\d{1,}")) {
                filminfo( s );
            }
            break;
    }