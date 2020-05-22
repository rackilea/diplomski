try {
    zipper.extractAll(dest);
    break;
} catch(ZipException ze) {
    continue;
}