public static void possibleCombinations(int maxLength, char[] list, String curr) {
    if(!keepworking){
      return;
    }
    if (curr.length() == maxLength) {
        tries++;
        if (curr.equals(password)) {
            System.out.println(curr);
            keepworking = false;
            return;
        }
    } else {
        for (int i = 0; i < list.length; i++) {
            String oldCurr = curr;
            curr = curr + CHOICES[i];
            possibleCombinations(maxLength, CHOICES, curr);
            curr = oldCurr;
        }
    }
}