public CorsConfiguration applyPermitDefaultValues() {
        [...]
        if (this.allowedMethods == null) {
            this.setAllowedMethods(Arrays.asList(
                    HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name()));
        }
        [...]
        return this;
    }