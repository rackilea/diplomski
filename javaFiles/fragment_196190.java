public String findURL(String googleURL) 
 {
        String [] first = googleURL.split("url?q=");
        String[] final = method[1].split("sa=");
        url = final[0];
        url = url.replace("%2B", "+");
        return url
 }