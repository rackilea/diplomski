Class<?> requestClass = data.getClass();
    Method method = requestClass.getMethod("setTRANSCOMMONPARAMS", TransCommonParamsContent.class);
    TransCommonParamsContent newTransCommonParams = new TransCommonParamsContent();
    newTransCommonParams.setMCUTOKEN(transCommonParamsContent.getMCUTOKEN());
    newTransCommonParams.setMCUUSERTOKEN(transCommonParamsContent.getMCUUSERTOKEN());
    method.invoke(data, newTransCommonParams);

    String responseString = doPost(getBaseUri(), data, String.class);
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(responseClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        @SuppressWarnings("unchecked")
        Response response = (Response) unmarshaller.unmarshal(new StringReader(responseString));
        return response;
    } catch (Exception e) {
        JAXBContext jaxbContext = JAXBContext.newInstance(RESPONSEGENERAL.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        RESPONSEGENERAL errorResponse = (RESPONSEGENERAL) unmarshaller.unmarshal(new StringReader(responseString));