try(corrReader)
    {
        while ((corrLine = corrReader.readLine())!=null)
        {
            corrText = corrLine.trim();
        //Coverage details regex search begin - write to coverageOutput
            Matcher file1Matcher = fileName1.matcher(corrText); 
            if(file1Matcher.find())
            {
                coverageOutput = new ArrayList<String>();
                coverageOutput.add(file1Matcher.group("fileName1"));
                coverage.add(coverageOutput);
            } //end if(file1Matcher)

            Matcher baseMatcher = noBase.matcher(corrText);
            if (baseMatcher.find()) 
            {
                noBaseText = baseMatcher.group("noBase");
                noBaseText = "noBaseData";
                coverageOutput.add(noBaseText);
            } //end if(baseMatcher)
            Matcher totCovMatcher = totalCoverage.matcher(corrText);
            if(totCovMatcher.matches()) 
            {
                totalCovText = totCovMatcher.group("totalCoverage");
                coverageOutput.add(totalCovText);
            } //end if(totCovMatcher)
            Matcher covByMatcher = coverageBy.matcher(corrText);
            if(covByMatcher.matches()) 
            {
                covByPct = covByMatcher.group("coverageBy");
                covByProvider = covByMatcher.group("baseStation");
                coverageOutput.add(covByPct);
                coverageOutput.add(covByProvider);
            } //end if(covByMatcher)