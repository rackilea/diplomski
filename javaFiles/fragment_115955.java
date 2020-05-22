String sample = "(Signal = 90) OR (Latitude = 123.653) AND (BatteryTemperature > 54.01)"        
        String key = "BatteryTemperature";
        String[] array = sample.split(" AND | OR ");
        for(String tmp :array)
        {
            System.out.println("String: " + tmp);
            Pattern pattern = Pattern.compile("\\(("+key+") (>|<|=) (-?\\d+.\\d*)\\)");
            Matcher matcher = pattern.matcher(tmp);
            if(matcher.find())
            {
                for(int i = 0; i<=matcher.groupCount(); i++)
                {
                    if(matcher.group(i).equals(key))
                    {
                        sample = sample.replaceAll(matcher.group(i-1), key + " " + matcher.group(i+1) + " " + convertCelsiusToFahrenheit(matcher.group(i+2)));
                    }
                }
            }
        }