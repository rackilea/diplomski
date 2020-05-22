@POST
@Path("/insertDataInDB")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public void insertDataInDB2(@FormDataParam("inputfile")
MultipartFormDataInput inputfile) {

    Map<String, List<InputPart>> uploadForm = inputfile.getFormDataMap();
    List<InputPart> inputParts = uploadForm.get("inputfile");

    //i have only one inputPart
    InputPart inputPart = inputParts.get(0);

    try {
        InputStream inputStream = inputPart.getBody(InputStream.class, null);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getSheetName());

    } catch (IOException e) {
        e.printStackTrace();
    }
}