public static boolean xyzThere(String str) {
      for (int i=0; i < str.length()-3; i++){
        if ("xyz".equalsIgnoreCase(str.substring(i+1, i+4)) && str.charAt(i) != '.'){
          return true;
        }
      }
      return false;
}