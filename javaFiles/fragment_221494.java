@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/zip");
    try (ZipOutputStream zos = new ZipOutputStream(resp.getOutputStream())) {
        for (File f : downloadedFileLocation.listFiles()) {
            zos.putNextEntry(new ZipEntry(f.getName()));
            Files.copy(f.toPath(), zos);
            Files.delete(f.toPath());
        }
    }
}