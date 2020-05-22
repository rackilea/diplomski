public String getBodyPartAsString (List<InputPart> parts) throws IOException
    {
               InputPart part = parts.get(0);
               String value = part.getBody(String.class, null);

        return value;
    }

        @POST
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        public Response create (@Context UriInfo uriInfo,
                                @Context HttpServletRequest req,
                                MultipartFormDataInput input) throws IOException, ParseException
        {

                Map<String, List<InputPart>> formParts = input.getFormDataMap();

                if (!formParts.containsKey("model"))
                    {
                        throw new IllegalArgumentException("Cannot create document due to param missing (model)");
                    }

                //Parsea los datos y los pone en el DTO
                String str = getBodyPartAsString(formParts.get("model"));
        }