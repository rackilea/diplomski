VideoEditor.transcodeVideo(
    videoTranscodeSuccess,
    videoTranscodeError,
    {
        fileUri: file.fullPath,
        fileUri2: file2.fullPath,
        outputFileName: videoFileName,
        quality: VideoEditorOptions.Quality.LOW_QUALITY,
        outputFileType: VideoEditorOptions.OutputFileType.MPEG4,
        optimizeForNetworkUse: VideoEditorOptions.OptimizeForNetworkUse.YES,
        duration: 2
    }
);