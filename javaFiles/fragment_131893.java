public class ResponseUtils {

  public static <T> T convertToEntity(Response response, 
                                      Class<T> target)
                          throws RestResponseException {
    if (response.getStatus() == 200) {
      return response.readEntity(target);
    } else {
      RestError err = response.readEntity(RestError.class);
      // my exception class
      throw new RestResponseException(err);
    }
  }

  // this method is for reading Set<> and List<> from Response
  public static <T> T convertToGenericType(Response response,
                                           GenericType<T> target)
                          throws RestResponseException {
    if (response.getStatus() == 200) {
      return response.readEntity(target);
    } else {
      RestDTOError err = response.readEntity(RestError.class);
      // my exception class
      throw new RestResponseException(err);
    }
  }

}