public void addToBundleCoverageList() throws IOException {

        loadExecutionData();

        bundleCoverage = analyzeStructure();

        coverageList.add(bundleCoverage);

    }

    public void createCoverageList() throws IOException 
    {

        for(int i=0; i<coverageList.size(); i++)
        {
            HTMLFormatter htmlFormatter = new HTMLFormatter();
            IReportVisitor visitor = htmlFormatter
                    .createVisitor(new FileMultiReportOutput(reportDirectory));


            visitor.visitInfo(execFileLoader.getSessionInfoStore().getInfos(),
                    execFileLoader.getExecutionDataStore().getContents());

            visitors.add(visitor);

        }

    }

    public void createReportFromList() throws IOException
    {
        MultiReportVisitor mrv = new MultiReportVisitor(visitors);
        IReportGroupVisitor irgv = mrv.visitGroup("group");
        for(int i=0; i<coverageList.size(); i++)
        {
            irgv.visitBundle(coverageList.get(i), indexHtml);
            System.out.println("Processing: " + coverageList.get(i).getName());
        }
        mrv.visitEnd();
    }