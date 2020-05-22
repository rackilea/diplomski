protected void loadSearchParameterMappings() {
        getSearchParameterMappings().put("id", "id");
        getSearchParameterMappings().put("firstName", "firstName");
        getSearchParameterMappings().put("lastName", "lastName");
        getSearchParameterMappings().put("email", "email");
        getSearchParameterMappings().put("serialNumber", "device.serialNumber");
        getSearchParameterMappings().put("phoneNumber", "device.phoneNumber");
    }


 private Path<String> getParameterPath(final Root<T> root) {

        String[] keys = criteria.getKey().split("\\.");

        Path<String> path = null;

        for (String key : keys) {
            path = (path != null) ? path.get(key) : root.get(key);
            // verify all the mappings are done correctly or this mapping is not supported
            if (path == null) {
                throw new 
InvalidSearchParameterException(ErrorCode.INVALID_SEARCH_PARAM, key);
            }
        }

        if (path == null) {
            throw new InvalidSearchParameterException(ErrorCode.INVALID_SEARCH_PARAM, criteria.getKey());
        }

        return path;
    }