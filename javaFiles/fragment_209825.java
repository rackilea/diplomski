someTest() { print "Test was run." }

@AfterTest
afterTest() { print "AfterTest method was run." }

@TestListener
testListener() { print "TestListener method was run." }