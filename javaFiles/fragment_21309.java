// REGISTER THE CONVERTER
ConversionService conversionService = DefaultConversionService.getSharedInstance();
ConverterRegistry converters = (ConverterRegistry) conversionService;
converters.addConverter(StringToInstantConverter.INSTANCE);

ObjectMapper mapper = new ObjectMapper();
ArrayNode patchArray = mapper.createArrayNode();
ObjectNode patch = mapper.createObjectNode();
patch.put("op", "replace");
patch.put("path", "dateOfBirth");
patch.put("value", "1971-01-01T01:01:01.001Z");
// [{"op": "replace", "path": "dateOfBirth", "value": "1971-01-01T01:01:01.001Z"}]
patchArray.add(patch);

// apply the patch
User patchedUser = applyPatchOnObject(User.class, new User(), patchArray);