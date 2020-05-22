public Compiler createCompiler() throws JasperException {
    if(this.jspCompiler != null) {
        return this.jspCompiler;
    } else {
        this.jspCompiler = null;
        if(this.options.getCompiler() == null) {
            this.jspCompiler = this.createCompiler("org.apache.jasper.compiler.JDTCompiler");
            if(this.jspCompiler == null) {
                this.jspCompiler = this.createCompiler("org.apache.jasper.compiler.AntCompiler");
            }
        } else {
            this.jspCompiler = this.createCompiler("org.apache.jasper.compiler.AntCompiler");
            if(this.jspCompiler == null) {
                this.jspCompiler = this.createCompiler("org.apache.jasper.compiler.JDTCompiler");
            }
        }

        if(this.jspCompiler == null) {
            throw new IllegalStateException(Localizer.getMessage("jsp.error.compiler"));
        } else {
            this.jspCompiler.init(this, this.jsw);
            return this.jspCompiler;
        }
    }
}