String input = "\"Spring 2014\" / \"Summer 2012\" / \"Fall 2011\"";
        String[] splittedValues = input.split("/");

        StringBuilder stringBuilder = new StringBuilder();

        for(String value : splittedValues)
        {
            String temp = value.replaceAll("[\"\"]", "").trim();
            temp = temp.substring(temp.length() - 2, temp.length());
            stringBuilder.append("\"");
            if(value.contains("Spring"))
            {
                stringBuilder.append(temp).append("1\"");
            }
            else if(value.contains("Summer"))
            {
                stringBuilder.append(temp).append("2\"");
            }
            else
            {
                stringBuilder.append(temp).append("3\"");
            }

            stringBuilder.append(" for ").append(value);


        }
        System.out.println("stringBuilder : "+stringBuilder.toString());