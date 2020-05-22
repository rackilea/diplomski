@POST
@Path("/childpath")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response createLoan(
         @FormDataParam("cipherData") String cipherData,  // encrypted xml data
         @FormDataParam("sessionId") String sessionId,   // sessionId (you can also get it through httpHeader)
         @FormDataParam("payslip") InputStream payslipS,  // this is your file
         @FormDataParam("payslip") FormDataContentDisposition payslipD ) {   // this is your file details like file name and file type

// If you need to store the file in DB as blob
byte[] byte = IOUtils.toByteArray(payslipS);   // IOUtils is org.apache.commons.io.IOUtils (you need to add its dependency in pom.xml or build.gradle)
// Now store the byte[] in Blob field of DB
return Response.status(200).entity('success').build();
}