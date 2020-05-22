HttpServletRequestWrapper wrap = new HttpServletRequestWrapper(servletRequest){


        @Override
        public String getHeader(String name) {

            if (name.equals(HttpHeaders.AUTHORIZATION)){
                String encoding = Base64.getEncoder().encodeToString((credentials.getUser().concat(":").concat(credentials.getPassword()).getBytes()));
                return "Basic " + encoding;
            }
            return super.getHeader(name);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            if (name.equals(HttpHeaders.AUTHORIZATION)){
                List<String> temp = new ArrayList<>();
                String encoding = Base64.getEncoder().encodeToString((credentials.getUser().concat(":").concat(credentials.getPassword()).getBytes()));
                temp.add("Basic " + encoding);
                return Collections.enumeration(temp);
            }
            return super.getHeaders(name);
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            // TODO Auto-generated method stub
            List<String> temp = Collections.list(super.getHeaderNames());
            temp.add(HttpHeaders.AUTHORIZATION);
            return Collections.enumeration(temp);

        }

    };