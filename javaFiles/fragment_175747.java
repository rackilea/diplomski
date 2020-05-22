public class DownloadProgress<DATA> {
    private final float progress;
    private final DATA data;

    public DownloadProgress(float progress) {
        this.progress = progress;
        this.data = null;
    }

    public DownloadProgress(@NonNull DATA data) {
        this.progress = 1f;
        this.data = data;
    }

    public float getProgress() {
        return progress;
    }

    public boolean isDone() {
        return data != null;
    }

    public DATA getData() {
        return data;
    }
}