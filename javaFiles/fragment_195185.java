if (convertedImgStr.contains("::::::::::")) {
    VIEW.updateStatus(STS_WARNING_IMG);
    LOG.warn("Converter might have failed to transform the image correctly");
} else if (convertedImgStr.contains("null")) {
    VIEW.updateStatus(STS_FAILURE_IMG);
    LOG.warn("Converter failed to transform the image");
} else {
    VIEW.updateStatus(STS_SUCCESS_IMG);
}