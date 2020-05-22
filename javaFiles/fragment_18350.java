String filename = /* path to a file */

File file = new File(filename);

response.setContentType(new MimetypesFileTypeMap().getContentType(file));
response.setContentLength((int)file.length());
response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));

InputStream is = new FileInputStream(file);
FileCopyUtils.copy(is, response.getOutputStream());

return null;