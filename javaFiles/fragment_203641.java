String base = "http://xxx:port/jira/rest/api/2/search?jql=project='TP' AND (status='Ready for INT Deployment' or status = 'Ready for UAT Deployment')";
base += getPartialIssueList();
System.out.println(base);
------------------------------------------
http://xxx:port/jira/rest/api/2/search?jql=project='TP' AND 
(status='Ready for INT Deployment' or status = 'Ready for UAT Deployment') AND 
(key="NN-09876" OR key="NN-65432" OR key="NN-65430")