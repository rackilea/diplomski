String artifactName="testplan"; 
    Object artifact;//create reference 


    switch (artifactName) {
                case testplan: {
                    artifact = new TestPlan();//assing it here
                    break;
                }
                case testsuite: {
                    artifact = new TestSuite();//or here 
                    break;
                }