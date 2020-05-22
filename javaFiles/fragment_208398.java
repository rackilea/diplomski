String uri = RequestUtils.getUri(request);
for ( Pattern pattern : excludedPatterns ) {
    if (pattern.matcher(uri).matches()) {
        return true;
    }
}
return false;