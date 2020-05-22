private String getFileName(final Part part) {
      final String partHeader = part.getHeader("content-disposition");
      LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
      for (String content : part.getHeader("content-disposition").split(";")) {
          if (content.trim().startsWith("filename")) {
              return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
          }
      }
      return null;
}