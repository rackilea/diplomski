private Size getBestSize(List<Size> supportedPreviewSizes, float aspectRatio) {
    int surfaceHeight = videoView.getHeight();

    Size bestSize = null;
    Size backupSize = null;
    for (Size size : supportedPreviewSizes) {
        float previewAspectRatio = size.width / (float)size.height;
        previewAspectRatio = Math.round(previewAspectRatio * 10) / 10f;
        if (previewAspectRatio == aspectRatio) { // Best size must match preferred aspect ratio
            if (bestSize == null || Math.abs(surfaceHeight - size.height) < Math.abs(surfaceHeight - bestSize.height))
                bestSize = size;
        }
        else if (bestSize == null) { // If none of supported sizes match preferred aspect ratio, backupSize will be used
            if (backupSize == null || Math.abs(surfaceHeight - size.height) < Math.abs(surfaceHeight - backupSize.height))
                backupSize = size;
        }
    }
    return bestSize != null ? bestSize : backupSize;
}