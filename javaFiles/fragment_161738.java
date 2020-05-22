String s1 = "{\"email_prompted\":\"n\",\"error\":\"o\",\"pin\":\"c\",\"antiphishing_prompted\":\"n\",\"antiphishing\":\"n\"}";

    String s2 = "EoPnAn";

    String[] s1Parts = s1.replaceAll("[\\{}\"]", "").split("[,:]");
    boolean equal = s2.substring(1, 2).equals(s1Parts[3]) /* error */
            && s2.substring(3, 4).equals(s1Parts[5]) /* pin */
            && s2.substring(5, 6).equals(s1Parts[9]); /* antiphishing */
    if(equal) {
        System.out.println("ok");
    }