import groovy.json.*

def t = """{"LoginResult":{"AccessToken":"abc…","SessionToken":"abcd…."},"SessionID":null,"UserDetails":{"FirstName":"","LastName":"","SalesPersonCode":"","SalesPersonDiscount":0.0,"IsServiceAdvisor":true,"EmployeeNo":""},"Companies":[{"Name":" Test ","Locations":[{"Code":"L12","Name":"Branch "}],"Makes":[{"Code":"","Name":""}],"Roles":[{"Name":""}],"Address":"","Address2":"No. 88 Century Avenue","BankAcctNo":"","BankBranchNo":"","BankName":"","City":"","Email":"","FaxNo":"","IBAN":"","PhoneNo":"","PostCode":"","SwiftBIC":"","VatRegNo":"","Web":"","DisplayName":"","DisplayName2":""}]}
"""
def j = new JsonSlurper().parseText(t)
j.Companies.Locations.flatten().each { println it}
assert j.Companies.Locations.flatten().find { it.Code=='L12' && it.Name=='Branch ' }