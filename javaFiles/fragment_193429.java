for (File fle : fileArr1) {
    if (fle.isFile()) {
        fileVec1.add(fle);
        System.out.println("    " + fle.getName());
    }
}