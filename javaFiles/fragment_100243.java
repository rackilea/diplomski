Path src = filesystem.getPath(job.srcDir)
int numSubDirs = job.pattern.contains("**") ? Integer.MAX_VALUE : 1

        Files.walk(src, numSubDirs)
                .filter{Path path -> filesystem.getPathMatcher("glob:${job.pattern}").matches(path.getFileName())}
                .filter{Path path -> job.days ? (new Date()) - new Date(path.toFile().lastModified()) <= job.days : true}
                .each{ Path path ->
                    actions[job.action](job, path)
                    fileCount++
                }