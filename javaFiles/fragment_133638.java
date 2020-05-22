@Override
        public String encodeURL(String url) {
            ResourceUrlProvider resourceUrlProvider = getResourceUrlProvider();
            if (resourceUrlProvider == null) {
                logger.debug("Request attribute exposing ResourceUrlProvider not found");
                return super.encodeURL(url);
            }
            initIndexLookupPath(resourceUrlProvider);
            if (url.length() >= this.indexLookupPath) {
                String prefix = url.substring(0, this.indexLookupPath);
                int suffixIndex = getQueryParamsIndex(url);
                String suffix = url.substring(suffixIndex);
                String lookupPath = url.substring(this.indexLookupPath, suffixIndex);
                lookupPath = resourceUrlProvider.getForLookupPath(lookupPath);
                if (lookupPath != null) {
                    return super.encodeURL(prefix + lookupPath + suffix);
                }
            }
            return super.encodeURL(url);
        }