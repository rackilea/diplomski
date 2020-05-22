String s = "1234.567";
    Float fp = 0f;
    Float fpd = 0f;
    int i =0;
    while(s.charAt(i) != '.') {
            fp = (fp * 10) + Float.parseFloat(s.substring(i, (i+1)));
            i++;
        }
    int d = s.indexOf('.');
    for(i = s.length()- 1; i > d; i--) {
        fpd = (fpd * 0.1f) + (Float.parseFloat(s.substring(i, (i+1))) * 0.1f);  
    }
    fp += fpd;
    System.out.println(fp);