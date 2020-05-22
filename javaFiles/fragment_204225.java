SCENARIO: verify login landing page
META-DATA: {"TestCase_ID":"BP_L&R_001","description":"verify login landing page ","scope":"REGRESSION","feature":"PRO_EXCLUDE"]}    
    Given user is on homepage
    When clicks on login link
    Then verify page title text with title '${loginpage.title}'
END