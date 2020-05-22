public static boolean ConsecutiveCheckerAscending(String x) {
x = x.toLowerCase();

for (int i = 0; i < x.length() - 1; i++) {
    if ((int)x.charAt(i) + 1 != ((int)x.charAt(i + 1))) 
    {
        return false;
    }
}
return true;
}

public static boolean ConsecutiveCheckerDescending(String x) {
x = x.toLowerCase();

for (int i = 0; i < x.length() - 1; i++) {
    if((int)x.charAt(i) - 1 != ((int)x.charAt(i + 1)))
    {
        return false;
    }
}
return true;
}