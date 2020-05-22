@GET
@Path("/companies/all")
public ApiResponse getAllCompanies(){
    //Set your ApiResponse Object with the companies List.
    ApiResponse apiResponse = new ApiResponse(companies);
    return apiResponse;
}