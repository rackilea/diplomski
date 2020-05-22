public class Response {
    private String name;
    private String subject;

    Response(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public static Response.ResponseBuilder builder() {
        return new Response.ResponseBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static class ResponseBuilder {
        private String name;
        private String subject;

        ResponseBuilder() {
        }

        public Response.ResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Response.ResponseBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Response build() {
            return new Response(this.name, this.subject);
        }

        public String toString() {
            return "Response.ResponseBuilder(name=" + this.name + ", subject=" + this.subject + ")";
        }
    }
}