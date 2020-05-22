NodeList loanIDList = loanApplicationElement.getElementsByTagName("LoanId");
 Element loanIDElement = (Element) loanIDList.item(0);

 NodeList textIDList = loanIDElement.getChildNodes();
 response.setLoanID(Integer.parseInt(((Node)textIDList.item(0)).getNodeValue().trim()));

//-------
 NodeList loanReferenceList = loanApplicationElement.getElementsByTagName("LoanReference");
 Element loanReferenceElement = (Element) loanReferenceList.item(0);

 NodeList textLRList = loanReferenceElement.getChildNodes();
 response.setLoanReference(Integer.parseInt(((Node) textLRList.item(0)).getNodeValue().trim()));
//-------
 NodeList loanStatusList = loanApplicationElement.getElementsByTagName("LoanStatus");
 Element loanStatusElement = (Element) loanStatusList.item(0);

 NodeList textLSList = loanStatusElement.getChildNodes();
 response.setLoanStatus(((Node) textLSList.item(0)).getNodeValue().trim());