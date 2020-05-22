response.setHeader("Pragma", "public");
response.setHeader("Expires", "0");
response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
response.setHeader("Content-type", "application-download");
response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
response.setHeader("Content-Transfer-Encoding", "binary");