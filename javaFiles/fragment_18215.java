if (this.type === "POST" || this.type === "GET" || this.type === "PATCH") {
    if (this.opts.responseContentType) {
      responseContentType = this.opts.responseContentType;
    } else {
      responseContentType = "application/json";
    }
  }