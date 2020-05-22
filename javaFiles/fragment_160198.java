import java.io.File;
File file = new File('c:/customers.csv');
InputStream inputFile =  new FileInputStream(file);
String[] lines = inputFile.text.split('\n');
List<String[]> rows = lines.collect {it.split(',')}
log.info('There are ' + rows.size() + ' customers to be inserted');
for(int i = 0; i < rows.size(); i++) {
  String[] row = rows.get(i);
  String errorcode = row[0];
// log.info(errorcode)
 String errorDescription = row[1];
 //log.info(errorDescription)
testRunner.testCase.testSuite.project.setPropertyValue('errorcode', errorcode);
testRunner.testCase.testSuite.project.setPropertyValue('errorDescription', errorDescription);
testRunner.runTestStepByName("createCard-1");
log.info(errorcode +"Finsihed")
}