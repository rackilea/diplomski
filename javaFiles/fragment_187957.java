String content ="   <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
"<!DOCTYPE DocName PUBLIC \"-//msg//msg1 Project_Name 1.1//EN\" \"My_Project_Name_V1_1.dtd\">\n"+
"<My_Project_Name dtdVersion=\"V1_1\" fileName=\"Guidance_Document_SQL\" softwareName=\"prototype\" softwareVersion=\"0.1\" productionDate=\"2012-01-02\">\n"+
"    <ApplicantFileReference>ABCD#1234</ApplicantFileReference>\n"+
"    <ApplicantName languageCode=\"EF\">Michael Smith</ApplicantName>\n"+
"    <ApplicantNameLatin>Michael Smith </ApplicantNameLatin>\n"+
"    <ProductTitle languageCode=\"EF\">Some Example </InventionTitle>\n"+
"    <TotalQuantity>88</TotalQuantity>\n"+
"    <Example_Data exampleIDNumber=\"1\">\n"+
"        <Exm_Seq>\n"+
"            <Exm_Seq_length>7</Exm_Seq_length>\n"+
"            <Exm_Seq_type>MM</Exm_Seq_type>\n"+
"            <Exm_Seq_div>PAT</Exm_Seq_div>\n"+
"        <Exm_Seq>\n"+
"    </Example_Data>";

// Define newline character to look for. \r \r\n \n         
String newLine = "\n";

// Where the body starts        
String bodyStart ="<Example_Data";

// Base index defined by bodyStart
int indx = content.indexOf(bodyStart);

// Grab the head.
String head = content.substring(0, indx - 1);

// Find the last index of newline
int lastNewline = head.lastIndexOf(newLine);
String body;
// If we found a newline in head and the character before our match isn't a closing bracket, get content from newline
if(lastNewLine != -1 && content.charAt(indx - 1) != '>') {
    body = content.substring(lastNewline + 1);
}
// business as usual
else {
    body = content.substring(indx);
}

System.out.println(body);