ByteArrayOutputStream baos = new ByteArrayOutputStream(3000); 
  final PrintWriter w = new PrintWriter(new OutputStreamWriter(baos, "UTF-8"));

  HttpServletResponse wrapper = new HttpServletResponseWrapper(response) {

                        @Override
                        public PrintWriter getWriter() throws IOException {
                            return w;
                        }

                    };