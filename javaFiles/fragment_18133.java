for(int i = 0; i < SmallerVals.size(); i++) {
    String val = SmallerVals.get(i);

    for(int j = 0 ; j < val.length() ; j++) { 
        if(j == val.length()-1) {
            System.out.println("Yes");
            break;
        }

        if( Character.isLetter(val.charAt(j)) && val.charAt(j+1) != '\'' ) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
            j++;
        }
    }
}