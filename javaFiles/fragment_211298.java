// no context
Validation<String, Object> v1 = Validation.invalid("error");

// the context set explicitly 
Validation<String, AdRequest> v2 = Validation.<String, AdRequest>invalid("error");

// the type is determined by the context implicitly
Validation<String, AdRequest> v3 = Validation.invalid("error");