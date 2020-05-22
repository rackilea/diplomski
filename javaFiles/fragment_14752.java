private StringBuffer getResultContent(Result result, int numberOfTestFiles)
       {
        int numberOfTest = result.getRunCount();
        int numberOfTestFail = result.getFailureCount();
        int numberOfTestIgnore = result.getIgnoreCount();
        int numberOfTestSuccess = numberOfTest - numberOfTestFail - numberOfTestIgnore;
        int successPercent = (numberOfTest != 0) ? numberOfTestSuccess * 100 / numberOfTest : 0;
        double time = result.getRunTime();
        StringBuffer myContent = new StringBuffer("<h1>Junitee Test Report</h1><h2>Result</h2><table border=\"1\"><tr><th>Test Files</th><th>Tests</th><th>Success</th>");
         if ((numberOfTestFail > 0) || (numberOfTestIgnore > 0)) {
           myContent.append("<th>Failure</th><th>Ignore</th>");
         }

         myContent.append("<th>Test Time (seconds)</th></tr><tr");
         if ((numberOfTestFail > 0) || (numberOfTestIgnore > 0)) {
           myContent.append(" style=\"color:red\" ");
         }
         myContent.append("><td>");
         myContent.append(numberOfTestFiles);
         myContent.append("</td><td>");
         myContent.append(numberOfTest);
         myContent.append("</td><td>");
         myContent.append(successPercent);
         myContent.append("%</td><td>");
         if ((numberOfTestFail > 0) || (numberOfTestIgnore > 0)) {
           myContent.append(numberOfTestFail);
           myContent.append("</td><td>");
           myContent.append(numberOfTestIgnore);
           myContent.append("</td><td>");
         }

         myContent.append(Double.valueOf(time / 1000.0D));
         myContent.append("</td></tr></table>");
         return myContent;
       }