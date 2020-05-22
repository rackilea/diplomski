String[] phrases = ref.split("\\s+");
    for(String s : phrases)
        if(s.contains("<in>"))
        {
            String[] split = s.split("<in>");
            for(String t : split)
                System.out.println(t);
        }