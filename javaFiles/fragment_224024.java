private String getYouTubeUrl(String text)
    {
        String finalUrl = null;
        String p = "(//www.youtube(?:-nocookie)?.com/(?:v|embed)/([a-zA-Z0-9-_]+).*)";

        if(text.contains("src"))
        {
            if(text.contains("//") && text.contains("frameborder"))
            {
                int startpos = text.indexOf("/", text.indexOf("src="));
                int endpos = text.indexOf("frameborder");
                String url=text.substring(startpos, endpos-2);

                if(url.matches(p))
                {
                    finalUrl = url;
                }
                else
                {
                    Window.alert("You have entered a wrong embed code");
                }   
            }
            else
            {
                Window.alert("You have entered a wrong embed code");
            }   
        }
        else
        {
            Window.alert("You have entered a wrong embed code");
        }
        return finalUrl;
    }