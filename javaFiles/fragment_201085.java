/**
 * this method imports properties to a test case from a file.
 * @param context
 * @param filePath
 */
def importPropertiesToTestCase(def context,String filePath) {
    def  props = new Properties()
    def propFile = new File(filePath)
    //load the properties files into properties object
    props.load(propFile.newDataInputStream())
    //loop thru the properties and set them at test case level
    props.each {
        context.testCase.setPropertyValue(it.key, it.value.toString())
    }
}
//How to use above method. Make sure you have file with properties, change path if needed.
importPropertiesToTestCase(context, 'D:/Temp/testCase.properties')