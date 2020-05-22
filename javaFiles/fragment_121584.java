Files.copy(source, target, options); // 'options' should include COPY_ATTRIBUTES

BasicFileAttributes srcAttrs = Files.readAttributes(source, BasicFileAttributes.class);
BasicFileAttributeView tgtView = Files.getFileAttributeView(target, BasicFileAttributeView.class);

tgtView.setTimes(srcAttrs.lastModifiedTime(), srcAttrs.lastAccessTime(), srcAttrs.creationTime());