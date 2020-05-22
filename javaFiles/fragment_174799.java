package test.xyz;


import org.springframework.validation.Validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateAnnotation {
    Class<? extends Validator> value();
}