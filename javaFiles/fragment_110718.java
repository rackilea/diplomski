fun concatenateAudioFiles(files: Collection<File>, outFile: File) {
    val args = mutableListOf<String>()

    files.forEach { file ->
        args.add("-i")
        args.add(file.absolutePath)
    }

    // Create filter
    val filterStringBuilder = StringBuilder()
    files.forEachIndexed { index, _ ->
        filterStringBuilder.append("[$index:0]")
    }
    filterStringBuilder.append("concat=n=")
    filterStringBuilder.append(files.size)
    filterStringBuilder.append(":v=0:a=1[out]")

    args.add("-filter_complex")
    args.add(filterStringBuilder.toString())
    args.add("-map")
    args.add("[out]")
    args.add(outFile.absolutePath)
    logger.info { "Filter: ${args.joinToString(" ")}" }
    val result = executeCommand(args.toTypedArray())
    if (!result.isSuccessful()) {
        throw FfmpegException(result.toString())
    }
}