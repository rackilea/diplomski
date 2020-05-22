// We execute this on "ab*cd*ef", expecting "af".
for (int i = 0; i < sb.length(); i++) { // length = 8
    if (sb.charAt(i) + "" == "*") {
        // First execution, i = 2. Second, i = 5.
        sb.deleteCharAt(i-1);
        sb.deleteCharAt(i-1);
        sb.deleteCharAt(i-1);
        // After we executed the first time, we get that sb's length
        // is now 5! Wait, so next time when we try to delete the i-1 
        // character, we are removing...f? That cannot be right!
    }
}