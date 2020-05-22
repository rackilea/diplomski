@Target({METHOD, TYPE})
@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = ResourceErrorModel.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ResourceErrorModel.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ResourceErrorModel.class),
            @ApiResponse(code = 404, message = "Not Found", response = ResourceErrorModel.class),
            @ApiResponse(code = 409, message = "Conflict", response = ResourceErrorModel.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = ResourceErrorModel.class),
            @ApiResponse(code = 424, message = "Failed Dependency", response = ResourceErrorModel.class)})
public @interface CustomAPIResponse{}